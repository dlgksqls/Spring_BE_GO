package go.backend_go.controller;

import go.backend_go.dtos.place.PlaceRegisterUpdateDto;
import go.backend_go.dtos.place.PlaceViewDto;
import go.backend_go.entity.Place;
import go.backend_go.entity.Place_Tag;
import go.backend_go.service.PlaceService;
import go.backend_go.service.PlaceTagService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final PlaceTagService placeTagService;

    @GetMapping("/")
    public List<PlaceViewDto> viewPlaces(){
        return placeService.findAll();
    }

    @GetMapping("/{placeName}")
    public PlaceViewDto viewPlace(@PathVariable String placeName){
        return placeService.findPlaceDto(placeName);
    }

    @PostMapping("/join")
    public HttpStatus save(PlaceRegisterUpdateDto newPlace){

        Place place = new Place();

        Place savePlace = placeService.save(place, newPlace);

        if (savePlace == null){
            return HttpStatus.CONFLICT;
        }

        placeTagService.savePlaceTag(savePlace, newPlace.getPlace_tag());

        return HttpStatus.CREATED;
    }

    @PostMapping("/update/{placeName}")
    public PlaceRegisterUpdateDto update(String updatePlaceName, PlaceRegisterUpdateDto updatePlace){

        Place place = placeService.findPlace(updatePlaceName);

        placeService.update(place, updatePlace);
        return updatePlace;
    }
}
