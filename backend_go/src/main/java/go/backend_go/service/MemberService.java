package go.backend_go.service;

import go.backend_go.dtos.member.MemberDetailDto;
import go.backend_go.dtos.member.MemberJoinDto;
import go.backend_go.entity.Member;
import go.backend_go.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberDetailDto> viewMembersDto(){

        List<Member> members= memberRepository.findAll();
        List<MemberDetailDto> returnMembers = new ArrayList<>();

        for (Member member : members) {
            MemberDetailDto dto = new MemberDetailDto(member);
            returnMembers.add(dto);
        }

        return returnMembers;
    }

    public MemberDetailDto findMemberDto(String loginId){

        Member findMember = memberRepository.findByLoginId(loginId);
        MemberDetailDto returnMember = new MemberDetailDto(findMember);

        return returnMember;
    }

    public Member findMember(String logId){

        Member findMember = memberRepository.findByLoginId(logId);
        return findMember;
    }

    public boolean save(Member member, MemberJoinDto dto){
        member.join(dto);
        Member findMember = memberRepository.findByLoginId(member.getLoginId());

        if (findMember != null){
            return false;
        }
        memberRepository.save(member);
        return true;
    }
}
