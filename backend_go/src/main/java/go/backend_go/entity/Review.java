package go.backend_go.entity;

import go.backend_go.dtos.review.ReviewRegisterDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity @Getter
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String content;
    @Max(5) @NotNull
    private int score;
    private LocalDateTime created_at;

    private String reviewMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    public void createReview(ReviewRegisterDto dto){

        this.content = dto.getContent();
        this.score = dto.getScore();
        this.created_at = dto.getCreated_at();
        this.reviewMemberId = dto.getMember().getLoginId();
        this.member = dto.getMember();
        this.place = dto.getPlace();
    }

    public void deleteMember(){
        this.member = null;
        this.reviewMemberId = "알 수 없는 사용자";
    }
}
