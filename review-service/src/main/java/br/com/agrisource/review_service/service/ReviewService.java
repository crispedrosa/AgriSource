package br.com.agrisource.review_service.service;

import br.com.agrisource.review_service.model.Review;
import br.com.agrisource.review_service.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        return reviewRepository.findById(id).map(review -> {
            review.setProductId(reviewDetails.getProductId());
            review.setUserId(reviewDetails.getUserId());
            review.setRating(reviewDetails.getRating());
            review.setComment(reviewDetails.getComment());
            review.setReviewDate(reviewDetails.getReviewDate());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found with id " + id));
    }
}
