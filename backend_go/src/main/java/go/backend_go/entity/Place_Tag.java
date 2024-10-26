package go.backend_go.entity;

import go.backend_go.dtos.place.PlaceRegisterUpdateDto;
import go.backend_go.repository.PlaceTagRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity @Getter
public class Place_Tag {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public Place_Tag(Place place, Tag tag) {
        this.place = place;
        this.tag = tag;
    }

    public Place_Tag() {

    }
}
