package go.backend_go.dtos.place;

import go.backend_go.dtos.tag.PlaceTagDto;
import go.backend_go.entity.Place;
import go.backend_go.entity.Place_Tag;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PlaceViewDto {

    private String placeName;
    private String info;
    private String classification;
    private String streetNameAddr;
    private boolean parking;
    private String call;
    private List<PlaceTagDto> tags;

    public PlaceViewDto(Place place) {
        this.placeName = place.getPlaceName();
        this.info = place.getInfo();
        this.classification = place.getClassification();
        this.streetNameAddr = place.getStreetNameAddr();
        this.parking = place.isParking();
        this.call = place.getCall();
        this.tags = place.getPlace_tag().stream()
                .map(pt -> new PlaceTagDto(pt.getTag().getTagName())) // 태그 정보만 포함
                .collect(Collectors.toList());
    }
}
