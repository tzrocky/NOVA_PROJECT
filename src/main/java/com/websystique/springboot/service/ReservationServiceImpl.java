package com.websystique.springboot.service;
 
import java.util.List;
 
import com.websystique.springboot.model.Reservation;
import com.websystique.springboot.model.Eleve;
import com.websystique.springboot.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService{
 
    @Autowired
    private ReservationRepository reservationRepository;
 
    public Reservation findById(Long id) {
        return reservationRepository.findOne(id);
    }
 
    public Reservation findByEleve(Eleve eleve) {
        return reservationRepository.findByEleve(eleve);
    }
 
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
 
    public void updateReservation(Reservation reservation){
        saveReservation(reservation);
    }
 
    public void deleteReservationById(Long id){
        reservationRepository.delete(id);
    }
 
    public void deleteAllReservations(){
        reservationRepository.deleteAll();
    }
 
    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }
 
    public boolean isReservationExist(Reservation reservation) {
        return findByEleve(reservation.getEleve()) != null;
    }

//	@Override
//	public Reservation findByAllReservationDatas(Reservation reservation) {
//		// TODO Auto-generated method stub
//		return null;
//	}
 
}