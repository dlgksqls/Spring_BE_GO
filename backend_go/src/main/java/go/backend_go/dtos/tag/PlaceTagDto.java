package go.backend_go.dtos.tag;

import lombok.Data;

@Data
public class PlaceTagDto {

    String placeName;

    public PlaceTagDto(String placeName) {
        this.placeName = placeName;
    }
}
