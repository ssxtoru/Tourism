package com.jdbc.tourism.controller;

import com.jdbc.tourism.entity.ReviewAndRatings;
import com.jdbc.tourism.service.ReviewAndRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourism/hotels")
public class ReviewAndRatingsController {
    @Autowired
    private ReviewAndRatingsService reviewService;

    @GetMapping("/{hotelId}/get-reviews")
    public List<ReviewAndRatings> getReviewsForHotel(@PathVariable Long hotelId) {
        return reviewService.getReviewsForHotel(hotelId);
    }

    @PostMapping("/{hotelId}/reviews")
    public ResponseEntity<ReviewAndRatings> addReview(@PathVariable Long hotelId, @RequestParam Long userId, @RequestBody ReviewAndRatings review) {
        ReviewAndRatings newReview = reviewService.addReview(hotelId, userId, review.getComment(), review.getRating());
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
}

