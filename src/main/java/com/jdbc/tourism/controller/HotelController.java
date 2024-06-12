package com.jdbc.tourism.controller;

import com.jdbc.tourism.model.HotelDto;
import com.jdbc.tourism.service.HotelService;
import org.springframework.web.bind.annotation.*;
import com.jdbc.tourism.entity.User;
import com.jdbc.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/tourism/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping
    public List<HotelDto> getAvailableHotels() {
        return hotelService.getAvailableHotels();
    }

    @PostMapping("/{id}/book")
    public HotelDto bookHotel(@PathVariable Long id) {
        return hotelService.bookHotel(id);
    }

    @PostMapping("/{id}/cancel")
    public void cancelBooking(@PathVariable Long id) {
        hotelService.cancelBooking(id);
    }


    @PostMapping("/create")
    public HotelDto createHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.createHotel(hotelDto);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}