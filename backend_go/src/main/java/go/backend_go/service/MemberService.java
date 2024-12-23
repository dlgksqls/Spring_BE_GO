package go.backend_go.service;

import go.backend_go.dtos.member.MemberDetailDto;
import go.backend_go.dtos.member.MemberJoinDto;
import go.backend_go.entity.Member;
import go.backend_go.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberDetailDto> viewMembersDto(){

        List<Member> members= memberRepository.findAll();
        List<MemberDetailDto> returnMembers = new ArrayList<>();

        for (Member member : members) {
            if (members.isEmpty()){
                throw new NoSuchElementException();
            }

            MemberDetailDto dto = new MemberDetailDto(member);
            returnMembers.add(dto);
        }

        return returnMembers;
    }

    public Member findMember(String logId){

        Member findMember = memberRepository.findByLoginId(logId);
        if (findMember == null){
            throw new NoSuchElementException();
        }
        return findMember;
    }

    public MemberDetailDto save(Member member, MemberJoinDto dto){
        member.join(dto);

        duplicatedMemberCheck(dto.getLoginId());

        memberRepository.save(member);

        MemberDetailDto returnDto = new MemberDetailDto(member);
        return returnDto;
    }

    public boolean duplicatedMemberCheck(String memberId){
        Member saveMember = memberRepository.findByLoginId(memberId);

        if (saveMember != null){
            throw new IllegalArgumentException("중복된 ID가 존재합니다.");
        }
        return true;
    }

    public void deleteMember(String memberId){
        Member findMember = memberRepository.findByLoginId(memberId);
        memberRepository.delete(findMember);
    }

//    public MemberDetailDto findMemberDto(String loginId){
//
//        Member findMember = memberRepository.findByLoginId(loginId);
//        if (findMember == null){
//            throw new NoSuchElementException();
//        }
//        MemberDetailDto returnMember = new MemberDetailDto(findMember);
//
//        return returnMember;
//    }
}
