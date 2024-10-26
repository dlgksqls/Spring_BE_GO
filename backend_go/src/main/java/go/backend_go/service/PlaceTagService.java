package go.backend_go.service;

import go.backend_go.dtos.tag.PlaceTagDto;
import go.backend_go.entity.Place;
import go.backend_go.entity.Place_Tag;
import go.backend_go.entity.Tag;
import go.backend_go.repository.PlaceTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceTagService {

    private final PlaceTagRepository placeTagRepository;

    public void savePlaceTag(Place savePlace, List<Tag> tags){

        for (Tag tag : tags) {
            Place_Tag placeTag = new Place_Tag(savePlace, tag);
            placeTagRepository.save(placeTag);
        }
    }

    public List<PlaceTagDto> findPlaceByTag(String tagName) {
        List<Place> places = placeTagRepository.findAllByTagName(tagName); // List<Place>로 변경
        List<PlaceTagDto> returnDtos = new ArrayList<>();

        for (Place place : places) {
            PlaceTagDto dto = new PlaceTagDto(place.getPlaceName());
            returnDtos.add(dto);
        }

        return returnDtos;
    }
}
