package go.backend_go.dtos.memberLike;

import go.backend_go.entity.Member;
import go.backend_go.entity.Place;
import lombok.Data;

@Data
public class memberLikeViewDto {

    private String memberId;
    private String placeName;

    public memberLikeViewDto(Member member, Place place) {
        this.memberId = member.getLoginId();
        this.placeName = place.getPlaceName();
    }
}
