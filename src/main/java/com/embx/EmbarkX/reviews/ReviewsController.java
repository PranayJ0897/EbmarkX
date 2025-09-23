package com.embx.EmbarkX.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewsController {

    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping()
    private ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Reviews reviews) {
        return new ResponseEntity<>(reviewsService.createReview(companyId, reviews), HttpStatus.CREATED);
    }

    @GetMapping()
    private ResponseEntity<List<Reviews>> findAll(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewsService.findAll(companyId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    private ResponseEntity<Reviews> findByReviewId(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Reviews reviews = reviewsService.findById(companyId, reviewId);
        if (reviews != null) {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{reviewId}")
    private ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Reviews reviews) {
        boolean isUpdated = reviewsService.updateReview(companyId, reviewId, reviews);
        if (isUpdated)
            return new ResponseEntity<>("Review updated successfully!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not found!", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{reviewId}")
    private ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean isDeleted = reviewsService.deleteReviews(companyId, reviewId);
        if (isDeleted) {
            return new ResponseEntity<>("Review Deleted Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Deleted!", HttpStatus.NOT_FOUND);
        }
    }

}
