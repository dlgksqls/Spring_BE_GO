package go.backend_go.entity;

import go.backend_go.dtos.place.PlaceRegisterUpdateDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Place {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String placeName;
    //@NotNull
    private String info;
//    private Image image;

    // 업종
    //@NotNull
    private String classification;
    // 도로명 주소
    //@NotNull
    private String streetNameAddr;
    // 주차 가능 여부
    //@NotNull
    private boolean parking;
    // 전화 번호
    //@NotNull
    private String call;
    // 경도
    private float hardness;
    // 위도
    private float latitude;

    @OneToOne(mappedBy = "place")
    private Plan plan;

    @OneToMany(mappedBy = "place")
    private List<Review> place_reviews = new ArrayList<>();

    @OneToMany(mappedBy = "place")
    private List<Place_Tag> place_tag = new ArrayList<>();

    @OneToMany(mappedBy = "place")
    private List<User_Like> place_like_member = new ArrayList<>();

    @OneToMany(mappedBy = "place")
    private List<Schedule> place_schedule = new ArrayList<>();

    public void saveAndUpdate(PlaceRegisterUpdateDto dto) {
        this.placeName = dto.getPlaceName();
        this.info = dto.getInfo();
        this.classification = dto.getClassification();
        this.streetNameAddr = dto.getStreetNameAddr();
        this.parking = dto.isParking();
        this.call = dto.getCall();
        this.hardness = dto.getHardness();
        this.latitude = dto.getLatitude();

        updateTag(dto.getPlace_tag());
    }

    private void updateTag(List<Tag> tags){
        for (Tag tag : tags) {
            Place_Tag placeTag = new Place_Tag(this, tag);
            this.place_tag.add(placeTag);
        }
    }
}
