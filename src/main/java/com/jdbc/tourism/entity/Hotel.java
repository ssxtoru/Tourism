package com.jdbc.tourism.entity;

import com.jdbc.tourism.enums.Status;
import lombok.*;


import javax.persistence.*;


@Entity
@Table(name = "hotels")
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String rooms;
    private Status status;

}
