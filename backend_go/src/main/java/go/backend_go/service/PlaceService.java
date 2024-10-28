package go.backend_go.service;

import go.backend_go.dtos.place.PlaceRegisterUpdateDto;
import go.backend_go.dtos.place.PlaceViewDto;
import go.backend_go.entity.Place;
import go.backend_go.entity.Place_Tag;
import go.backend_go.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<PlaceViewDto> findAll(){

        List<Place> places = placeRepository.findAll();
        List<PlaceViewDto> returnPlace = new ArrayList<>();

        for (Place place : places) {
            PlaceViewDto dto = new PlaceViewDto(place);
            returnPlace.add(dto);
        }

        return returnPlace;
    }

    public Place save(Place place, PlaceRegisterUpdateDto dto){

        place.saveAndUpdate(dto);

        if (placeRepository.findByPlaceName(dto.getPlaceName()) != null){
            return null;
        }

        placeRepository.save(place);
        return place;
    }

    public PlaceRegisterUpdateDto update(Place place, PlaceRegisterUpdateDto dto){

        place.saveAndUpdate(dto);

        placeRepository.save(place);
        return dto;
    }

    public PlaceViewDto findPlaceDto(String placeName) {

        Place place = placeRepository.findByPlaceName(placeName);

        PlaceViewDto returnDto = new PlaceViewDto(place);

        return returnDto;
    }

    public Place findPlace(String placeName) {

        Place place = placeRepository.findByPlaceName(placeName);

        return place;
    }

    public void delete(String placeName) {
        placeRepository.deleteByPlaceName(placeName);
    }
}
