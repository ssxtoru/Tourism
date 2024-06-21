package com.jdbc.tourism.service;
import com.jdbc.tourism.config.HotelNotFoundException;
import com.jdbc.tourism.entity.Hotel;
import com.jdbc.tourism.enums.Status;
import com.jdbc.tourism.model.HotelDto;
import com.jdbc.tourism.repo.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDto> getAvailableHotels() {
        List<Hotel> hotels = hotelRepository.findByStatus(Status.AVAILABLE);
        return hotels.stream()
                .map(hotel -> new HotelDto(hotel))
                .collect(Collectors.toList());
    }
    public HotelDto bookHotel(Long id) {
        Hotel hotelToBook = hotelRepository.findByIdAndStatus(id, Status.AVAILABLE);
        if (hotelToBook != null) {
            hotelToBook.setStatus(Status.BOOKED);
            hotelRepository.save(hotelToBook);
            return new HotelDto(hotelToBook);
        } else {
            throw new HotelNotFoundException("Hotel not found or not available");
        }
    }
    public void cancelBooking(Long id) {
        Hotel hotel = hotelRepository.findByIdAndStatus(id, Status.BOOKED);
        if (hotel != null) {
            hotel.setStatus(Status.AVAILABLE);
            hotelRepository.save(hotel);
        } else {
            throw new HotelNotFoundException("Hotel not found or not booked");
        }
    }

    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setRooms(hotelDto.getRooms());
        hotel.setStatus(Status.AVAILABLE);
        hotelRepository.save(hotel);
        return new HotelDto(hotel);
    }

    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel not found"));
        hotelRepository.delete(hotel);
    }
}