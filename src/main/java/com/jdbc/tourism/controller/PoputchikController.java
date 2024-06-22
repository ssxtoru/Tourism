package com.jdbc.tourism.controller;

import com.jdbc.tourism.entity.Poputchik;
import com.jdbc.tourism.service.PoputchikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourism/poputchiks")
public class PoputchikController {
    @Autowired
    private PoputchikService poputchikService;

    @PostMapping("/create")
    public ResponseEntity<Poputchik> createTrip(@RequestParam Long userId, @RequestBody Poputchik poputchik) {
        Poputchik newPoputchik = poputchikService.createTrip(userId, poputchik.getDestination(), poputchik.getDepartureDate(), poputchik.getReturnDate(), poputchik.getMaxCompanions());
        return new ResponseEntity<>(newPoputchik, HttpStatus.CREATED);
    }

    @GetMapping("/destination")
    public List<Poputchik> findTripsByDestination(@RequestParam String destination) {
        return poputchikService.findTripsByDestination(destination);
    }

    @PostMapping("/{tripId}/companions")
    public ResponseEntity<Poputchik> addCompanionToTrip(@PathVariable Long tripId, @RequestParam Long userId) {
        Poputchik updatedTrip = poputchikService.addCompanionToTrip(tripId, userId);
        return new ResponseEntity<>(updatedTrip, HttpStatus.OK);
    }
}

