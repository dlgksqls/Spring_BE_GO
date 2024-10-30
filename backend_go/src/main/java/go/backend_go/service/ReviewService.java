package go.backend_go.service;

import go.backend_go.dtos.review.ReviewRegisterDto;
import go.backend_go.dtos.review.ReviewViewDto;
import go.backend_go.entity.Review;
import go.backend_go.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    public List<ReviewViewDto> viewAll() {

        List<Review> reviews = reviewRepository.findAll();
        List<ReviewViewDto> returnDto = new ArrayList<>();

        for (Review review : reviews) {
            ReviewViewDto dto = new ReviewViewDto(review);
            returnDto.add(dto);
        }
        return returnDto;
    }

    public ReviewViewDto save(Review review, ReviewRegisterDto dto) {
        review.createReview(dto);
        reviewRepository.save(review);

        ReviewViewDto returnDto = new ReviewViewDto(review);
        return returnDto;
    }

    public void delete(Long reviewId) {

        reviewRepository.deleteById(reviewId);
    }
}
