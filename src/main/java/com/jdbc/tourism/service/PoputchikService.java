package com.jdbc.tourism.service;

import com.jdbc.tourism.config.PoputchikNotFoundException;
import com.jdbc.tourism.config.UserNotFoundException;
import com.jdbc.tourism.entity.Poputchik;
import com.jdbc.tourism.entity.User;
import com.jdbc.tourism.repo.PoputchikRepository;
import com.jdbc.tourism.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PoputchikService {
    @Autowired
    private  PoputchikRepository poputchikRepository;

    @Autowired
    private  UserRepository userRepository;
    public  Poputchik createTrip(Long userId, String destination, LocalDate departureDate, LocalDate returnDate, int maxCompanions) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        Poputchik poputchik = new Poputchik();
        poputchik.setUser(user);
        poputchik.setDestination(destination);
        poputchik.setDepartureDate(departureDate);
        poputchik.setReturnDate(returnDate);
        poputchik.setMaxCompanions(maxCompanions);

        return poputchikRepository.save(poputchik);
    }

    public  List<Poputchik> findTripsByDestination(String destination) {
        return poputchikRepository.findByDestination(destination);
    }

    public  Poputchik addCompanionToTrip(Long tripId, Long userId) {
        Poputchik poputchik = poputchikRepository.findById(tripId).orElseThrow(() -> new PoputchikNotFoundException("Poputchik not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (poputchik.getCompanions().size() < poputchik.getMaxCompanions()) {
            poputchik.getCompanions().add(user);
            return poputchikRepository.save(poputchik);
        } else {
            throw new RuntimeException("Trip is already full");
        }
    }
}

