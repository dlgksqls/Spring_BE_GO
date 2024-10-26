package go.backend_go.repository;

import go.backend_go.entity.Place_Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceTagRepository extends JpaRepository<Place_Tag, Long> {
}
