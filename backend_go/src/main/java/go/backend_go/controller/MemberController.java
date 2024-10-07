package go.backend_go.controller;

import go.backend_go.dtos.MemberJoinDto;
import go.backend_go.entity.Member;
import go.backend_go.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public HttpStatus join(MemberJoinDto newMember){
        Member member = new Member();

        member.joinMember(newMember);
        boolean isSave = memberService.save(member);

        if (!isSave){
            // 아이디가 중복됨 == 충돌?
            return HttpStatus.CONFLICT;
        }

        return HttpStatus.CREATED;
    }

}
