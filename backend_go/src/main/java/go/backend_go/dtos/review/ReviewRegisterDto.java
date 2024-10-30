package go.backend_go.dtos.review;

import go.backend_go.entity.Member;
import go.backend_go.entity.Place;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewRegisterDto {

    private String content;
    private int score;
    private LocalDateTime created_at;

    private Member member;

    private Place place;
}
