package go.backend_go.controller;

import go.backend_go.dtos.member.MemberDetailDto;
import go.backend_go.dtos.member.MemberFixedDto;
import go.backend_go.dtos.member.MemberJoinDto;
import go.backend_go.entity.Member;
import go.backend_go.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public List<MemberDetailDto> members(){
        List<MemberDetailDto> members = memberService.viewMembersDto();
        return members;
    }

    @GetMapping("/{loginId}")
    public MemberDetailDto findMemberByPath(@PathVariable String loginId){
        MemberDetailDto findMember = memberService.findMemberDto(loginId);
        return findMember;
    }

    @Transactional // 변경감지를 위해서 변경 대상 조회한 후 하나의 트랜젝션안에서 수정 진행함
    @PostMapping("/fix/{loginId}")
    public MemberDetailDto fixMemberByPath(@PathVariable String loginId, MemberFixedDto dto){
        Member fixedMember = memberService.findMember(loginId);

        fixedMember.update(dto);
        //memberService.save(fixedMember);

        MemberDetailDto returnMember = new MemberDetailDto(fixedMember);
        return returnMember;
    }

    @PostMapping("/findMemberPost")
    public MemberDetailDto findMemberDto(String loginId){
        MemberDetailDto findMember = memberService.findMemberDto(loginId);
        return findMember;
    }

    @PostMapping("/join")
    public HttpStatus register(MemberJoinDto dto){
        Member member = new Member();

        boolean isSave = memberService.save(member, dto);

        if (!isSave){
            // 아이디가 중복됨 == 충돌?
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.CREATED;
    }

}
