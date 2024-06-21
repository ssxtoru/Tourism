package com.jdbc.tourism.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "poputchiks")
@Getter
@Setter
public class Poputchik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int maxCompanions;

    @ManyToMany
    @JoinTable(
            name = "poputchik_companions",
            joinColumns = @JoinColumn(name = "poputchik_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> companions;
}
