package com.websystique.springboot.repositories;
 
import com.websystique.springboot.model.Reservation;
import com.websystique.springboot.model.Eleve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByEleve(Eleve eleve);
}