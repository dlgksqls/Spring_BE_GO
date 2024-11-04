package go.backend_go.controller;

import go.backend_go.dtos.member.MemberDetailDto;
import go.backend_go.dtos.member.MemberFixedDto;
import go.backend_go.dtos.member.MemberJoinDto;
import go.backend_go.entity.Member;
import go.backend_go.entity.Review;
import go.backend_go.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public ResponseEntity<?> members(){
        try {
            List<MemberDetailDto> members = memberService.viewMembersDto();
            return ResponseEntity.ok(members);
        } catch (NoSuchElementException e){
            log.error("exception : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("회원 리스트가 비어있어 불러올 수 없습니다.");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> register(MemberJoinDto dto){
        try {
            Member member = new Member();

            MemberDetailDto returnDto = memberService.save(member, dto);
            return ResponseEntity.ok(returnDto);
        } catch (IllegalArgumentException e){
            log.error("exception = {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{loginId}")
    public ResponseEntity<?> findMemberByPath(@PathVariable String loginId){
        try {
            Member findMember = memberService.findMember(loginId);
            MemberDetailDto returnDto = new MemberDetailDto(findMember);
            return ResponseEntity.ok(returnDto);
        } catch (NoSuchElementException e){
            log.error("exception : {}",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 회원을 찾을 수 없습니다.");
        }
    }

    @Transactional // 변경감지를 위해서 변경 대상 조회한 후 하나의 트랜젝션안에서 수정 진행함
    @PatchMapping("/{loginId}")
    public ResponseEntity<?> fixMemberByPath(@PathVariable String loginId, MemberFixedDto dto){
        try {
            Member fixedMember = memberService.findMember(loginId);
            fixedMember.update(dto);
            MemberDetailDto returnMember = new MemberDetailDto(fixedMember);
            return ResponseEntity.ok(returnMember);
        } catch (NoSuchElementException e){
            log.error("exception : {}",e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 회원을 찾을 수 없습니다.");
        } catch (IllegalArgumentException e){
            log.error("exception : {}",e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/findMemberPost")
    public MemberDetailDto findMemberDto(String loginId) {
        Member findMember = memberService.findMember(loginId);
        MemberDetailDto returnDto = new MemberDetailDto(findMember);
        return returnDto;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMember(String loginId){
        Member findMember = memberService.findMember(loginId);
        List<Review> findMemberMemberReviews = findMember.getMember_reviews();
        if (!findMemberMemberReviews.isEmpty()){
            for (Review review : findMemberMemberReviews) {
                review.deleteMember();
            }
        }

        memberService.deleteMember(loginId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("삭제 완료.");
    }
}
