//package fr.autoecole.nova.novaschool.utils;
//
//import java.util.Date;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.PersistenceUnit;
//
//import fr.autoecole.nova.novaschool.controllers.IndividuJpaController;
//import fr.autoecole.nova.novaschool.controllers.MoniteurJpaController;
//import fr.autoecole.nova.novaschool.controllers.ProfilJpaController;
//import fr.autoecole.nova.novaschool.controllers.ReservationJpaController;
//import fr.autoecole.nova.novaschool.entities.Individu;
//import fr.autoecole.nova.novaschool.entities.Moniteur;
//import fr.autoecole.nova.novaschool.entities.Profil;
//import fr.autoecole.nova.novaschool.entities.Reservation;
//
//public class Main {
//	
//
////	@PersistenceUnit(unitName = "project_nico_rival")
////	private static EntityManagerFactory emf = null;
////	
//  public static void main(String[] a) throws Exception {
//    JPAUtil util = new JPAUtil();
//    
//    
//
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("project_nico_rival");
//    EntityManager em = emf.createEntityManager();
//    IndividuJpaController serviceIndiv = new IndividuJpaController(em);
//    MoniteurJpaController serviceMoniteur = new MoniteurJpaController(em);
//
//    ProfilJpaController serviceProfil = new ProfilJpaController(em);
//    ReservationJpaController serviceReservation = new ReservationJpaController(em); 
//    
//    em.getTransaction().begin();
//   // Professor emp = service.createProfessor(158, "John Doe", 45000);
//    
//    Profil profilE=serviceProfil.findProfil(0);
//    
//    Profil profilM=serviceProfil.findProfil(1);
//    
//    Individu indiv = new Individu();
//    indiv.setMatricule("I0001");
//    indiv.setNom("TSANE");
//    indiv.setPrenom("Rocky");
//    indiv.setProfil(profilE);
//    serviceIndiv.create(indiv);
//    
//    Moniteur moniteur = new Moniteur();
//    moniteur.setMatricule("M0001");
//    moniteur.setNom("RIVAL");
//    moniteur.setPrenom("Nicolas");
//    moniteur.setProfil(profilM);
//    serviceMoniteur.create(moniteur);
//    
//    Individu indiv2 = serviceIndiv.findIndividu(0);
//    Moniteur moniteur2 = serviceMoniteur.findMoniteur(0);
//    Reservation reservation=new Reservation();
//   // reservation.setIndividu(indiv);
//    reservation.setHoraireDebut(new Date());
//    reservation.setHoraireFin(new Date());
//    serviceReservation.destroy(0);
//    
//    indiv2.getReservations().add(reservation);
//    moniteur2.getReservations().add(reservation);
//    
//    
//    
//   
//    		//serviceReservation.create(reservation);
//    		
//    //em.flush();
//    em.getTransaction().commit();
//    //System.out.println("Persisted " + emp);
//
//    util.checkData("select * from Individu");
//
//    //em.close();
//    emf.close();
//  }
//}