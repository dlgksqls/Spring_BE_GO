package go.backend_go.repository;

import go.backend_go.entity.User_Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberLikeRepository extends JpaRepository<User_Like, Long> {

    @Query("select uk from User_Like uk join fetch uk.member m join fetch uk.place p where m.id = :userId and p.id = :placeId")
    User_Like findByUserNameAndPlaceName(@Param("userId") Long userId, @Param("placeId") Long placeId);
}
