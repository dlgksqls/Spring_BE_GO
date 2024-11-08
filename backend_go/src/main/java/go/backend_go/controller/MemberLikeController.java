package go.backend_go.controller;

import go.backend_go.dtos.memberLike.memberLikeViewDto;
import go.backend_go.dtos.memberLike.placeLikeDto;
import go.backend_go.entity.Member;
import go.backend_go.entity.Place;
import go.backend_go.entity.User_Like;
import go.backend_go.service.MemberLikeService;
import go.backend_go.service.MemberService;
import go.backend_go.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@Slf4j
public class MemberLikeController {

    private final MemberLikeService memberLikeService;
    private final MemberService memberService;
    private final PlaceService placeService;

    @PostMapping("/memberlike")
    public ResponseEntity<?> findMemberLike(String memberId){
        try {
            Member findMember = memberService.findMember(memberId);
            List<memberLikeViewDto> memberlikes = new ArrayList<>();

            for (User_Like userLike : findMember.getPlace_like_member()) {
                memberLikeViewDto dto = new memberLikeViewDto(userLike.getMember(), userLike.getPlace());
                memberlikes.add(dto);
            }

            return ResponseEntity.ok(memberlikes);

        } catch (NoSuchElementException e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{placeName}")
    public ResponseEntity<?> numberPlaceLike(@PathVariable String placeName){
        try {
            Place findPlace = placeService.findPlace(placeName);
            placeLikeDto dto = new placeLikeDto(findPlace.getPlaceName(), findPlace.getLikeNum());

            return ResponseEntity.ok(dto);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addMemberLike(String memberId, String placeName){
        Member findMember = memberService.findMember(memberId);
        Place findPlace = placeService.findPlace(placeName);

        memberLikeViewDto returnDto = memberLikeService.addLike(findMember, findPlace);

        return ResponseEntity.ok(returnDto);
    }
}
