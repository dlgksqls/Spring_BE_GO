package go.backend_go.repository;

import go.backend_go.entity.User_Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberLikeRepository extends JpaRepository<User_Like, Long> {
}
