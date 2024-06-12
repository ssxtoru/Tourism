package com.jdbc.tourism.enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    AVAILABLE("AVAILABLE"),
    BOOKED("RESERVED");


    final String description;
}
