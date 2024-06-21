package com.jdbc.tourism.repo;

import com.jdbc.tourism.entity.ReviewAndRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewAndRatings, Long> {
    List<ReviewAndRatings> findByHotelId(Long hotelId);
}
