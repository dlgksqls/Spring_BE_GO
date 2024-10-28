package go.backend_go.repository;

import go.backend_go.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p LEFT JOIN FETCH p.place_tag pt LEFT JOIN FETCH pt.tag WHERE p.placeName = :placeName")
    Place findByPlaceName(String placeName);

    void deleteByPlaceName(String placeName);
}
