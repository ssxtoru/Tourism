package com.jdbc.tourism.repo;

import com.jdbc.tourism.entity.Hotel;
import com.jdbc.tourism.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByStatus(Status status);
    Hotel findByIdAndStatus(Long id, Status status);
}