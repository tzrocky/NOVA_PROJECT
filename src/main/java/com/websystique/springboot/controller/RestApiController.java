package com.websystique.springboot.controller;
 
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.FactureEleve;
import com.websystique.springboot.model.FactureMoniteur;
import com.websystique.springboot.model.Moniteur;
import com.websystique.springboot.model.Profil;
import com.websystique.springboot.model.Reservation;
import com.websystique.springboot.model.Document;
import com.websystique.springboot.model.Eleve;
import com.websystique.springboot.service.FactureEleveService;
import com.websystique.springboot.service.FactureMoniteurService;
import com.websystique.springboot.service.MoniteurService;
import com.websystique.springboot.service.ProfilService;
import com.websystique.springboot.service.ReservationService;
import com.websystique.springboot.service.DocumentService;
import com.websystique.springboot.service.EleveService;
import com.websystique.springboot.util.CustomErrorType;
 
@RestController
@RequestMapping("/api")
public class RestApiController {
 
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
 
    @Autowired
    EleveService eleveService; //Service which will do all data retrieval/manipulation work
    
    @Autowired
    MoniteurService moniteurService; //Service which will do all data retrieval/manipulation work
 
    @Autowired
    FactureEleveService factureEleveService;
    
    @Autowired
    ProfilService profilService; //Service which will do all data retrieval/manipulation work
 
    @Autowired
    DocumentService documentService; //Service which will do all data retrieval/manipulation work
    
    @Autowired
    ReservationService reservationService; //Service which will do all data retrieval/manipulation work
 
    @Autowired
    FactureMoniteurService factureMoniteurService;
    
    // -------------------Retrieve All Eleves---------------------------------------------
 
    @RequestMapping(value = "/eleve/", method = RequestMethod.GET)
    public ResponseEntity<List<Eleve>> listAllEleves() {
        List<Eleve> eleves = eleveService.findAllEleves();
        if (eleves.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Eleve>>(eleves, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Eleve------------------------------------------
 
    @RequestMapping(value = "/eleve/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEleve(@PathVariable("id") long id) {
        logger.info("Fetching Eleve with id {}", id);
        Eleve eleve = eleveService.findById(Long.valueOf(id));
        if (eleve == null) {
            logger.error("Eleve with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Eleve with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Eleve>(eleve, HttpStatus.OK);
    }
 
    // -------------------Create a Eleve-------------------------------------------
 
    @PostMapping(value = "/eleve/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createEleve(@RequestBody Eleve eleve, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Eleve : {}", eleve);
 
        if (eleveService.isEleveExist(eleve)) {
            logger.error("Unable to create. A Eleve with name {} already exist", eleve.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Eleve with name " + 
            eleve.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        eleveService.saveEleve(eleve);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/eleve/{id}").buildAndExpand(eleve.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Eleve ------------------------------------------------
 
    @RequestMapping(value = "/eleve/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEleve(@PathVariable("id") long id, @RequestBody Eleve eleve) {
        logger.info("Updating Eleve with id {}", id);
 
        Eleve currentEleve = eleveService.findById(id);
 
        if (currentEleve == null) {
            logger.error("Unable to update. Eleve with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Eleve with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentEleve.setName(eleve.getName());
        currentEleve.setAge(eleve.getAge());
        currentEleve.setMatricule(eleve.getMatricule());
        currentEleve.setProfil(eleve.getProfil());
        currentEleve.setPrenom(eleve.getPrenom());
        currentEleve.setEmail(eleve.getEmail());
        currentEleve.setAdresse(eleve.getAdresse());
 
        eleveService.updateEleve(currentEleve);
        return new ResponseEntity<Eleve>(currentEleve, HttpStatus.OK);
    }
 
    // ------------------- Delete a Eleve-----------------------------------------
 
    @RequestMapping(value = "/eleve/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEleve(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Eleve with id {}", id);
 
        Eleve eleve = eleveService.findById(id);
        if (eleve == null) {
            logger.error("Unable to delete. Eleve with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Eleve with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        eleveService.deleteEleveById(id);
        return new ResponseEntity<Eleve>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Eleves-----------------------------
    @RequestMapping(value = "/eleve/", method = RequestMethod.DELETE)
    public ResponseEntity<Eleve> deleteAllEleves() {
        logger.info("Deleting All Eleves");
 
        eleveService.deleteAllEleves();
        return new ResponseEntity<Eleve>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
 
    // -------------------Retrieve All Moniteurs---------------------------------------------
    
    @RequestMapping(value = "/moniteur/", method = RequestMethod.GET)
    public ResponseEntity<List<Moniteur>> listAllMoniteurs() {
        List<Moniteur> moniteurs = moniteurService.findAllMoniteurs();
        if (moniteurs.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Moniteur>>(moniteurs, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Moniteur------------------------------------------
 
    @RequestMapping(value = "/moniteur/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMoniteur(@PathVariable("id") long id) {
        logger.info("Fetching Moniteur with id {}", id);
        Moniteur moniteur = moniteurService.findById(Long.valueOf(id));
        if (moniteur == null) {
            logger.error("Moniteur with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Moniteur with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Moniteur>(moniteur, HttpStatus.OK);
    }
 
    // -------------------Create a Moniteur-------------------------------------------
 
    @PostMapping(value = "/moniteur/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createMoniteur(@RequestBody Moniteur moniteur, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Moniteur : {}", moniteur);
 
        if (moniteurService.isMoniteurExist(moniteur)) {
            logger.error("Unable to create. A Moniteur with name {} already exist", moniteur.getNom());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Moniteur with name " + 
            moniteur.getNom() + " already exist."),HttpStatus.CONFLICT);
        }
        moniteurService.saveMoniteur(moniteur);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/moniteur/{id}").buildAndExpand(moniteur.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Moniteur ------------------------------------------------
 
    @RequestMapping(value = "/moniteur/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMoniteur(@PathVariable("id") long id, @RequestBody Moniteur moniteur) {
        logger.info("Updating Moniteur with id {}", id);
 
        Moniteur currentMoniteur = moniteurService.findById(id);
 
        if (currentMoniteur == null) {
            logger.error("Unable to update. Moniteur with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Moniteur with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentMoniteur.setNom(moniteur.getNom());
        //currentMoniteur.setAge(moniteur.getAge());
        currentMoniteur.setSalary(moniteur.getSalary());
        currentMoniteur.setMatricule(moniteur.getMatricule());
        currentMoniteur.setProfil(moniteur.getProfil());
        currentMoniteur.setPrenom(moniteur.getPrenom());
        //currentMoniteur.setFactureMoniteurList(moniteur.getFactureMoniteurList());
        
        moniteurService.updateMoniteur(currentMoniteur);
        return new ResponseEntity<Moniteur>(currentMoniteur, HttpStatus.OK);
    }
 
    // ------------------- Delete a Moniteur-----------------------------------------
 
    @RequestMapping(value = "/moniteur/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMoniteur(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Moniteur with id {}", id);
 
        Moniteur moniteur = moniteurService.findById(id);
        if (moniteur == null) {
            logger.error("Unable to delete. Moniteur with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Moniteur with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        moniteurService.deleteMoniteurById(id);
        return new ResponseEntity<Moniteur>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Moniteurs-----------------------------
    @RequestMapping(value = "/moniteur/", method = RequestMethod.DELETE)
    public ResponseEntity<Moniteur> deleteAllMoniteurs() {
        logger.info("Deleting All Moniteurs");
 
        moniteurService.deleteAllMoniteurs();
        return new ResponseEntity<Moniteur>(HttpStatus.NO_CONTENT);
    }
 
    
    
    
    @RequestMapping(value = "/profil/", method = RequestMethod.GET)
    public ResponseEntity<List<Profil>> listAllProfils() {
        List<Profil> profils = profilService.findAllProfils();
        if (profils.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Profil>>(profils, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Profil------------------------------------------
 
    @RequestMapping(value = "/profil/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProfil(@PathVariable("id") long id) {
        logger.info("Fetching Profil with id {}", id);
        Profil profil = profilService.findById(Long.valueOf(id));
        if (profil == null) {
            logger.error("Profil with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Profil with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Profil>(profil, HttpStatus.OK);
    }
 
    // -------------------Create a Profil-------------------------------------------
 
    @PostMapping(value = "/profil/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createProfil(@RequestBody Profil profil, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Profil : {}", profil);
 
        if (profilService.isProfilExist(profil)) {
            logger.error("Unable to create. A Profil with name {} already exist", profil.getIntituleProfil());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Profil with name " + 
            profil.getIntituleProfil() + " already exist."),HttpStatus.CONFLICT);
        }
        profilService.saveProfil(profil);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/profil/{id}").buildAndExpand(profil.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Profil ------------------------------------------------
 
    @RequestMapping(value = "/profil/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProfil(@PathVariable("id") long id, @RequestBody Profil profil) {
        logger.info("Updating Profil with id {}", id);
 
        Profil currentProfil = profilService.findById(id);
 
        if (currentProfil == null) {
            logger.error("Unable to update. Profil with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Profil with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentProfil.setIntituleProfil(profil.getIntituleProfil());
        //currentProfil.setAge(profil.getAge());
//        currentProfil.setSalary(profil.getSalary());
        currentProfil.setNiveau(profil.getNiveau());
        
        profilService.updateProfil(currentProfil);
        return new ResponseEntity<Profil>(currentProfil, HttpStatus.OK);
    }
 
    // ------------------- Delete a Profil-----------------------------------------
 
    @RequestMapping(value = "/profil/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProfil(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Profil with id {}", id);
 
        Profil profil = profilService.findById(id);
        if (profil == null) {
            logger.error("Unable to delete. Profil with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Profil with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        profilService.deleteProfilById(id);
        return new ResponseEntity<Profil>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Profils-----------------------------
    @RequestMapping(value = "/profil/", method = RequestMethod.DELETE)
    public ResponseEntity<Profil> deleteAllProfils() {
        logger.info("Deleting All Profils");
 
        profilService.deleteAllProfils();
        return new ResponseEntity<Profil>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    @RequestMapping(value = "/reservation/", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> listAllReservations() {
        List<Reservation> reservations = reservationService.findAllReservations();
        if (reservations.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Reservation------------------------------------------
 
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservation(@PathVariable("id") long id) {
        logger.info("Fetching Reservation with id {}", id);
        Reservation reservation = reservationService.findById(Long.valueOf(id));
        if (reservation == null) {
            logger.error("Reservation with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Reservation with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }
 
    // -------------------Create a Reservation-------------------------------------------
 
    @PostMapping(value = "/reservation/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Reservation : {}", reservation);
 
        if (reservationService.isReservationExist(reservation)) {
            logger.error("Unable to create. A Reservation with name {} already exist", reservation.getMoniteur() + " --- " + reservation.getEleve() + " --- " + reservation.getLieuReservation());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Reservation with name " + 
            		reservation.getMoniteur() + " --- " + reservation.getEleve() + " --- " + reservation.getLieuReservation() + " already exist."),HttpStatus.CONFLICT);
        }
        reservationService.saveReservation(reservation);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/reservation/{id}").buildAndExpand(reservation.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Reservation ------------------------------------------------
 
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation) {
        logger.info("Updating Reservation with id {}", id);
 
        Reservation currentReservation = reservationService.findById(id);
 
        if (currentReservation == null) {
            logger.error("Unable to update. Reservation with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Reservation with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentReservation.setLieuReservation(reservation.getLieuReservation());
        currentReservation.setEleve(reservation.getEleve());
        currentReservation.setMoniteur(reservation.getMoniteur());
        currentReservation.setHoraireDebut(reservation.getHoraireDebut());
        currentReservation.setHoraireFin(reservation.getHoraireFin());
        
        reservationService.updateReservation(currentReservation);
        return new ResponseEntity<Reservation>(currentReservation, HttpStatus.OK);
    }
 
    // ------------------- Delete a Reservation-----------------------------------------
 
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReservation(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Reservation with id {}", id);
 
        Reservation reservation = reservationService.findById(id);
        if (reservation == null) {
            logger.error("Unable to delete. Reservation with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Reservation with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        reservationService.deleteReservationById(id);
        return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Reservations-----------------------------
    @RequestMapping(value = "/reservation/", method = RequestMethod.DELETE)
    public ResponseEntity<Reservation> deleteAllReservations() {
        logger.info("Deleting All Reservations");
 
        reservationService.deleteAllReservations();
        return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    
    // -------------------Retrieve All Factures Moniteur ---------------------------------------------
    
    @RequestMapping(value = "/factureMoniteur/", method = RequestMethod.GET)
    public ResponseEntity<List<FactureMoniteur>> listAllFacturesMoniteur() {
        List<FactureMoniteur> factureMoniteurs = factureMoniteurService.findAllFacturesMoniteur();
        if (factureMoniteurs.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FactureMoniteur>>(factureMoniteurs, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/factureMoniteur/moniteur", method = RequestMethod.GET)
    public ResponseEntity<List<FactureMoniteur>> listAllFacturesMoniteurByMoniteur(@RequestParam(value="nom") String nom) {//@PathVariable String nom) {
    	Moniteur moniteur = moniteurService.findByNom(nom);
    	List<FactureMoniteur> factureMoniteurs = factureMoniteurService.findByMoniteur(moniteur);
        if (factureMoniteurs.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FactureMoniteur>>(factureMoniteurs, HttpStatus.OK);    }

    
    @RequestMapping(path = "/factureMoniteur/moniteur/{id}/", method = RequestMethod.GET)
    public ResponseEntity<List<FactureMoniteur>> listAllFacturesByIdMoniteur(@PathVariable Long id) {
    	Moniteur moniteur = moniteurService.findById(id);
    	List<FactureMoniteur> factureMoniteurs = factureMoniteurService.findByMoniteur(moniteur);
        if (factureMoniteurs.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FactureMoniteur>>(factureMoniteurs, HttpStatus.OK);    }

 
    // -------------------Retrieve Single Facture------------------------------------------
 
    @RequestMapping(value = "/factureMoniteur/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFactureMoniteur(@PathVariable("id") long id) {
        logger.info("Fetching FactureMoniteur with id {}", id);
        FactureMoniteur factureMoniteur = factureMoniteurService.findById(Long.valueOf(id));
        if (factureMoniteur == null) {
            logger.error("FactureMoniteur with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Facture with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FactureMoniteur>(factureMoniteur, HttpStatus.OK);
    }
 
    // -------------------Create a Facture-------------------------------------------
 
    @PostMapping(value = "/factureMoniteur/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createFactureMoniteur(@RequestBody FactureMoniteur factureMoniteur, UriComponentsBuilder ucBuilder) {
        logger.info("Creating FactureMoniteur : {}", factureMoniteur);
 
        if (factureMoniteurService.isFactureMoniteurExist(factureMoniteur)) {
            logger.error("Unable to create. A Facture with name {} already exist", factureMoniteur.getNumFacture());
            return new ResponseEntity(new CustomErrorType("Unable to create. A FactureMoniteur with name " + 
            factureMoniteur.getNumFacture() + " already exist."),HttpStatus.CONFLICT);
        }
        factureMoniteurService.saveFactureMoniteur(factureMoniteur);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/factureMoniteur/{id}").buildAndExpand(factureMoniteur.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Facture ------------------------------------------------
 
    @RequestMapping(value = "/factureMoniteur/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFacture(@PathVariable("id") long id, @RequestBody FactureMoniteur factureMoniteur) {
        logger.info("Updating FactureMoniteur with id {}", id);
 
        FactureMoniteur currentFacture = factureMoniteurService.findById(id);
 
        if (currentFacture == null) {
            logger.error("Unable to update. Facture with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Facture with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentFacture.setNumFacture(factureMoniteur.getNumFacture());
        currentFacture.setPrixUnitaire(factureMoniteur.getPrixUnitaire());
        currentFacture.setQuantite(factureMoniteur.getQuantite());
        currentFacture.setMoniteur(factureMoniteur.getMoniteur());
        //currentFacture.setReservation(factureMoniteur.getReservation());
 
        factureMoniteurService.updateFactureMoniteur(currentFacture);
        return new ResponseEntity<FactureMoniteur>(currentFacture, HttpStatus.OK);
    }
 
    // ------------------- Delete a Facture-----------------------------------------
 
    @RequestMapping(value = "/factureMoniteur/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFactureMoniteur(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Facture Moniteur with id {}", id);
 
        FactureMoniteur factureMoniteur = factureMoniteurService.findById(id);
        if (factureMoniteur == null) {
            logger.error("Unable to delete. Facture Moniteur with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Facture with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        factureMoniteurService.deleteFactureMoniteurById(id);
        return new ResponseEntity<FactureMoniteur>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Factures Moniteur -----------------------------
    @RequestMapping(value = "/factureMoniteur/", method = RequestMethod.DELETE)
    public ResponseEntity<FactureMoniteur> deleteAllFacturesMoniteur() {
        logger.info("Deleting All Factures");
 
        factureMoniteurService.deleteAllFacturesMoniteur();
        return new ResponseEntity<FactureMoniteur>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    
    // -------------------Retrieve All Factures Eleve ---------------------------------------------
    
    @RequestMapping(value = "/factureEleve/", method = RequestMethod.GET)
    public ResponseEntity<List<FactureEleve>> listAllFacturesEleve() {
        List<FactureEleve> factureEleves = factureEleveService.findAllFacturesEleve();
        if (factureEleves.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FactureEleve>>(factureEleves, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/factureEleve/eleve", method = RequestMethod.GET)
    public ResponseEntity<List<FactureEleve>> listAllFacturesEleveByEleve(@RequestParam(value="nom") String nom) {//@PathVariable String nom) {
    	Eleve eleve = eleveService.findByName(nom);
    	List<FactureEleve> factureEleves = factureEleveService.findByEleve(eleve);
        if (factureEleves.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FactureEleve>>(factureEleves, HttpStatus.OK);    }

    
    @RequestMapping(path = "/factureEleve/eleve/{id}/", method = RequestMethod.GET)
    public ResponseEntity<List<FactureEleve>> listAllFacturesByIdEleve(@PathVariable Long id) {
    	Eleve eleve = eleveService.findById(id);
    	List<FactureEleve> factureEleves = factureEleveService.findByEleve(eleve);
        if (factureEleves.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<FactureEleve>>(factureEleves, HttpStatus.OK);    }

 
    // -------------------Retrieve Single Facture------------------------------------------
 
    @RequestMapping(value = "/factureEleve/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFactureEleve(@PathVariable("id") long id) {
        logger.info("Fetching FactureEleve with id {}", id);
        FactureEleve factureEleve = factureEleveService.findById(Long.valueOf(id));
        if (factureEleve == null) {
            logger.error("FactureEleve with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Facture with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FactureEleve>(factureEleve, HttpStatus.OK);
    }
 
    // -------------------Create a Facture-------------------------------------------
 
    @PostMapping(value = "/factureEleve/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createFactureEleve(@RequestBody FactureEleve factureEleve, UriComponentsBuilder ucBuilder) {
        logger.info("Creating FactureEleve : {}", factureEleve);
 
        if (factureEleveService.isFactureEleveExist(factureEleve)) {
            logger.error("Unable to create. A Facture with name {} already exist", factureEleve.getNumFacture());
            return new ResponseEntity(new CustomErrorType("Unable to create. A FactureEleve with name " + 
            factureEleve.getNumFacture() + " already exist."),HttpStatus.CONFLICT);
        }
        factureEleveService.saveFactureEleve(factureEleve);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/factureEleve/{id}").buildAndExpand(factureEleve.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Facture ------------------------------------------------
 
    @RequestMapping(value = "/factureEleve/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFactureEleve(@PathVariable("id") long id, @RequestBody FactureEleve factureEleve) {
        logger.info("Updating FactureEleve with id {}", id);
 
        FactureEleve currentFacture = factureEleveService.findById(id);
 
        if (currentFacture == null) {
            logger.error("Unable to update. Facture with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Facture with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentFacture.setNumFacture(factureEleve.getNumFacture());
        currentFacture.setPrixUnitaire(factureEleve.getPrixUnitaire());
        currentFacture.setQuantite(factureEleve.getQuantite());
        currentFacture.setForfait(factureEleve.getForfait());
        currentFacture.setEleve(factureEleve.getEleve());
        //currentFacture.setReservation(factureEleve.getReservation());
 
        factureEleveService.updateFactureEleve(currentFacture);
        return new ResponseEntity<FactureEleve>(currentFacture, HttpStatus.OK);
    }
 
    // ------------------- Delete a Facture Eleve -----------------------------------------
 
    @RequestMapping(value = "/factureEleve/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFactureEleve(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Facture Eleve with id {}", id);
 
        FactureEleve factureEleve = factureEleveService.findById(id);
        if (factureEleve == null) {
            logger.error("Unable to delete. Facture Eleve with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Facture with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        factureEleveService.deleteFactureEleveById(id);
        return new ResponseEntity<FactureEleve>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Factures Eleve -----------------------------
    @RequestMapping(value = "/factureEleve/", method = RequestMethod.DELETE)
    public ResponseEntity<FactureEleve> deleteAllFacturesEleve() {
        logger.info("Deleting All Factures");
 
        factureEleveService.deleteAllFacturesEleve();
        return new ResponseEntity<FactureEleve>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
    
    
    // -------------------Retrieve All Factures Eleve ---------------------------------------------
    
    @RequestMapping(value = "/document/", method = RequestMethod.GET)
    public ResponseEntity<List<Document>> listAllDocument() {
        List<Document> documents = documentService.findAllDocuments();
        if (documents.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Document>>(documents, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Facture------------------------------------------
 
    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDocument(@PathVariable("id") long id) {
        logger.info("Fetching Document with id {}", id);
        Document document = documentService.findById(Long.valueOf(id));
        if (document == null) {
            logger.error("Document with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Facture with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Document>(document, HttpStatus.OK);
    }
 
    // -------------------Create a Facture-------------------------------------------
 
    @PostMapping(value = "/document/")//, method = RequestMethod.POST)
    public ResponseEntity<?> createDocument(@RequestBody Document document, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Document : {}", document);
 
        if (documentService.isDocumentExist(document)) {
            logger.error("Unable to create. A Facture with name {} already exist", document.getLibelle());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Document with name " + 
            document.getLibelle() + " already exist."),HttpStatus.CONFLICT);
        }
        documentService.saveDocument(document);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/document/{id}").buildAndExpand(document.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Document ------------------------------------------------
 
    @RequestMapping(value = "/document/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDocument(@PathVariable("id") long id, @RequestBody Document document) {
        logger.info("Updating Document with id {}", id);
 
        Document currentDocument = documentService.findById(id);
 
        if (currentDocument == null) {
            logger.error("Unable to update. Facture with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Facture with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentDocument.setLibelle(document.getLibelle());
        currentDocument.setType(document.getType());
        currentDocument.setLien(document.getLien());
        currentDocument.setCode(document.getCode());

        //currentFacture.setReservation(document.getReservation());
 
        documentService.updateDocument(currentDocument);
        return new ResponseEntity<Document>(currentDocument, HttpStatus.OK);
    }
 
    // ------------------- Delete a Document -----------------------------------------
 
    @RequestMapping(value = "/document/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDocument(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Document with id {}", id);
 
        Document document = documentService.findById(id);
        if (document == null) {
            logger.error("Unable to delete. Document with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Document with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        documentService.deleteDocumentById(id);
        return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Documents -----------------------------
    @RequestMapping(value = "/document/", method = RequestMethod.DELETE)
    public ResponseEntity<Document> deleteAllDocument() {
        logger.info("Deleting All Factures");
 
        documentService.deleteAllDocuments();
        return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
    }
    
}