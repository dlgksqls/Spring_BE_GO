package go.backend_go.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Entity @Getter
public class User_Like {

    public User_Like() {

    }

    public User_Like(Member member, Place place) {
        this.member = member;
        this.place = place;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;
}
