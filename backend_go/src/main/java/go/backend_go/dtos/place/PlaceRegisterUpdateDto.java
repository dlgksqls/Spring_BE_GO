package go.backend_go.dtos.place;

import lombok.Data;

@Data
public class PlaceRegisterUpdateDto {

    public PlaceRegisterUpdateDto(String placeName, String info, String classification
            , String streetNameAddr, boolean parking, String call, float hardness, float latitude) {
        this.placeName = placeName;
        this.info = info;
        this.classification = classification;
        this.streetNameAddr = streetNameAddr;
        this.parking = parking;
        this.call = call;
        this.hardness = hardness;
        this.latitude = latitude;
    }

    private String placeName;
    private String info;
    private String classification;
    private String streetNameAddr;
    private boolean parking;
    private String call;
    private float hardness;
    private float latitude;
}
