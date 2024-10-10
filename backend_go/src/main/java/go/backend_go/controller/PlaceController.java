package go.backend_go.controller;

import go.backend_go.dtos.place.PlaceRegisterUpdateDto;
import go.backend_go.dtos.place.PlaceViewDto;
import go.backend_go.entity.Place;
import go.backend_go.service.PlaceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/")
    public List<PlaceViewDto> viewPlaces(){
        return placeService.findAll();
    }

    @GetMapping("/{placeName}")
    public PlaceViewDto viewPlace(String placeName){
        return placeService.findPlaceDto(placeName);
    }

    @PostMapping("/join")
    public HttpStatus save(PlaceRegisterUpdateDto newPlace){

        Place place = new Place();

        boolean isSave = placeService.save(place, newPlace);

        if (!isSave){
            return HttpStatus.CONFLICT;
        }

        return HttpStatus.CREATED;
    }

    @PostMapping("/update/{placeName}")
    public PlaceRegisterUpdateDto update(String updatePlaceName, PlaceRegisterUpdateDto updatePlace){

        Place place = placeService.findPlace(updatePlaceName);

        placeService.update(place, updatePlace);
        return updatePlace;
    }
}
