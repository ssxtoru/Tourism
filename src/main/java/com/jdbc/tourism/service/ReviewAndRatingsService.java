package com.jdbc.tourism.service;

import com.jdbc.tourism.config.HotelNotFoundException;
import com.jdbc.tourism.config.UserNotFoundException;
import com.jdbc.tourism.entity.Hotel;
import com.jdbc.tourism.entity.ReviewAndRatings;
import com.jdbc.tourism.entity.User;
import com.jdbc.tourism.repo.HotelRepository;
import com.jdbc.tourism.repo.ReviewRepository;
import com.jdbc.tourism.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewAndRatingsService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ReviewAndRatings> getReviewsForHotel(Long hotelId) {
        return reviewRepository.findByHotelId(hotelId);
    }

    public ReviewAndRatings addReview(Long hotelId, Long userId, String comment, int rating) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        ReviewAndRatings review = new ReviewAndRatings();
        review.setHotel(hotel);
        review.setUser(user);
        review.setComment(comment);
        review.setRating(rating);
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }
}

