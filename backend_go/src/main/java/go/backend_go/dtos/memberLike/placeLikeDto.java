package go.backend_go.dtos.memberLike;

import go.backend_go.entity.Place;
import lombok.Data;

@Data
public class placeLikeDto {

    private String placeName;
    private int likeNum;

    public placeLikeDto(String placeName, int likeNum) {
        this.placeName = placeName;
        this.likeNum = likeNum;
    }
}
