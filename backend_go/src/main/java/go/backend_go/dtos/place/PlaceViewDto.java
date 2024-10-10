package go.backend_go.dtos.place;

import go.backend_go.entity.Place;
import lombok.Data;

@Data
public class PlaceViewDto {

    public PlaceViewDto(Place place) {
        this.placeName = place.getPlaceName();
        this.info = place.getInfo();
        this.classification = place.getClassification();
        this.streetNameAddr = place.getStreetNameAddr();
        this.parking = place.isParking();
        this.call = place.getCall();
    }

    private String placeName;
    private String info;
    private String classification;
    private String streetNameAddr;
    private boolean parking;
    private String call;
}
