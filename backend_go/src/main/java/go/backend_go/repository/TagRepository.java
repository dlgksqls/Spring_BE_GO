package go.backend_go.repository;

import go.backend_go.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByTagName(String tagName);
}
