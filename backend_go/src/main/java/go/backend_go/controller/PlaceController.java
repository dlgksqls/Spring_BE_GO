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

    @GetMapping("")
    public List<PlaceViewDto> viewPlaces(){
        return placeService.findAll();
    }

    @PostMapping("")
    public HttpStatus save(PlaceRegisterUpdateDto newPlace){

        Place place = new Place();

        Place savePlace = placeService.save(place, newPlace);

        if (savePlace == null){
            return HttpStatus.CONFLICT;
        }

        //placeTagService.savePlaceTag(savePlace, newPlace.getPlace_tag());

        return HttpStatus.CREATED;
    }

    @GetMapping("/{placeName}")
    public PlaceViewDto viewPlace(@PathVariable String placeName){
        return placeService.findPlaceDto(placeName);
    }

    @PatchMapping("/{placeName}")
    public PlaceViewDto update(@PathVariable String placeName, PlaceRegisterUpdateDto updateInfo){

        Place place = placeService.findPlace(placeName);

        placeService.update(place, updateInfo);

        PlaceViewDto returnDto = new PlaceViewDto(place);

        return returnDto;
    }

    @DeleteMapping("/{placeName}")
    public String delete(@PathVariable String placeName){
        placeService.delete(placeName);
        return "success";
    }
}
