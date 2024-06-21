package com.jdbc.tourism.model;

import com.jdbc.tourism.entity.Hotel;
import com.jdbc.tourism.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDto {
    private Long id;
    private String name;
    private String address;
    private String rooms;
    private Status status;


    public HotelDto(Hotel hotelToBook) {
    }
}
