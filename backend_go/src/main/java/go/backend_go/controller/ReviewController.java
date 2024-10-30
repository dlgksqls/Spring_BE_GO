package go.backend_go.controller;

import go.backend_go.dtos.review.ReviewRegisterDto;
import go.backend_go.dtos.review.ReviewViewDto;
import go.backend_go.entity.Review;
import go.backend_go.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("")
    public List<ReviewViewDto> viewAllReview(){

        return reviewService.viewAll();
    }

    @PostMapping("")
    public ReviewViewDto save(ReviewRegisterDto dto){

        Review review = new Review();

        return reviewService.save(review, dto);
    }

    @DeleteMapping("/delete")
    public String delete(Long reviewId){

        reviewService.delete(reviewId);

        return "성공";
    }
}
