package go.backend_go.dtos.place;

import go.backend_go.entity.Place_Tag;
import go.backend_go.entity.Tag;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaceRegisterUpdateDto {

    public PlaceRegisterUpdateDto(String placeName, String info, String classification
            , String streetNameAddr, boolean parking, String call, float hardness, float latitude, List<Tag> tag) {
        this.placeName = placeName;
        this.info = info;
        this.classification = classification;
        this.streetNameAddr = streetNameAddr;
        this.parking = parking;
        this.call = call;
        this.hardness = hardness;
        this.latitude = latitude;
        this.place_tag = tag;
    }

    private String placeName;
    private String info;
    private String classification;
    private String streetNameAddr;
    private boolean parking;
    private String call;
    private float hardness;
    private float latitude;
    private List<Tag> place_tag;
}
