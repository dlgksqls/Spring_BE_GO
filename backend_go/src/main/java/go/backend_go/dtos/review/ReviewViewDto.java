package go.backend_go.dtos.review;

import go.backend_go.entity.Review;
import lombok.Data;

@Data
public class ReviewViewDto {

    private String content;
    private int score;

    public ReviewViewDto(Review review) {
        this.content = review.getContent();
        this.score = review.getScore();
    }
}
