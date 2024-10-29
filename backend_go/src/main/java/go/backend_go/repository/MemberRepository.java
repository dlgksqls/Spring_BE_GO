package go.backend_go.repository;

import go.backend_go.dtos.member.MemberDetailDto;
import go.backend_go.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByLoginId(String loginId);

//    @Query(value = "select m from Member m left join fetch m.member_plan mp where m.id = :id")
//    Optional<Member> findById(Long id);
}
