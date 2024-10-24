package go.backend_go.dtos.place;

import go.backend_go.entity.Place;
import go.backend_go.entity.Place_Tag;
import lombok.Data;

import java.util.List;

@Data
public class PlaceViewDto {

    public PlaceViewDto(Place place) {
        this.placeName = place.getPlaceName();
        this.info = place.getInfo();
        this.classification = place.getClassification();
        this.streetNameAddr = place.getStreetNameAddr();
        this.parking = place.isParking();
        this.call = place.getCall();
        this.tags = place.getPlace_tag();
    }

    private String placeName;
    private String info;
    private String classification;
    private String streetNameAddr;
    private boolean parking;
    private String call;
    private List<Place_Tag> tags;
}
