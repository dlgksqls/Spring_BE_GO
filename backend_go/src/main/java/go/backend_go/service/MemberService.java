package go.backend_go.service;

import go.backend_go.dtos.MemberJoinDto;
import go.backend_go.entity.Member;
import go.backend_go.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean save(Member member){

        Member findMember = memberRepository.findByLoginId(member.getLoginId());

        if (findMember != null){
            return false;
        }

        memberRepository.save(member);
        return true;
    }
}
