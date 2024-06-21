package com.jdbc.tourism.repo;

import com.jdbc.tourism.entity.Poputchik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoputchikRepository extends JpaRepository<Poputchik,Long> {
     List<Poputchik> findByDestination(String destination);
}
