package go.backend_go.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String placeName;
    @NotNull
    private String info;
//    private Image image;

    // 업종
    @NotNull
    private String classification;
    // 도로명 주소
    @NotNull
    private String streetNameAddr;
    // 주차 가능 여부
    @NotNull
    private boolean parking;
    // 전화 번호
    @NotNull
    private String call;
    // 경도
    private float hardness;
    // 위도
    private float latitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @OneToOne(mappedBy = "place")
    private Plan plan;

    @OneToMany(mappedBy = "place")
    private List<Review> place_reviews = new ArrayList<>();

    @OneToMany(mappedBy = "place")
    private List<Place_Tag> place_tag = new ArrayList<>();

    @OneToMany(mappedBy = "place")
    private List<User_Like> place_like_member = new ArrayList<>();
}
