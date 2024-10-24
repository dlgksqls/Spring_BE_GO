package go.backend_go.repository;

import go.backend_go.dtos.member.MemberDetailDto;
import go.backend_go.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByLoginId(String loginId);
}
