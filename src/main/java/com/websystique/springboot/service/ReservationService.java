
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.Reservation;
import com.websystique.springboot.model.Eleve;

import java.util.List;
 
public interface ReservationService {
     
    Reservation findById(Long id);
 
    Reservation findByEleve(Eleve eleve);
 
    void saveReservation(Reservation reservation);
 
    void updateReservation(Reservation reservation);
 
    void deleteReservationById(Long id);
 
    void deleteAllReservations();
 
    List<Reservation> findAllReservations();
 
    boolean isReservationExist(Reservation reservation);
}