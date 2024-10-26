package go.backend_go.repository;

import go.backend_go.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByPlaceName(String placeName);
}
