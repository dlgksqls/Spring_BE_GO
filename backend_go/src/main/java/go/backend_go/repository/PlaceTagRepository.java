package go.backend_go.repository;

import go.backend_go.entity.Place;
import go.backend_go.entity.Place_Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceTagRepository extends JpaRepository<Place_Tag, Long> {

    @Query(value = "select placeTag.place " +
            "from Place_Tag placeTag " +
            "where placeTag.tag.tagName = :tagName")
    List<Place> findAllByTagName(String tagName);
}
