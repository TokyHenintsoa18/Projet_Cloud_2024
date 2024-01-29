package com.example.cloud_project.controller;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.cloud_project.Models.PersonneModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PersonneController {
    @CrossOrigin(origins = "*")
    @GetMapping("/api/Personne/listsPersonne")
    public ResponseEntity<PersonneModel[]> listPersonnes() {
        // Get the list of personnes
        PersonneModel p = new PersonneModel();
        PersonneModel[] personnes = p.list_user();

        // Return a ResponseEntity with the JSON response
        return ResponseEntity.ok().body(personnes);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/api/Personne/insertPersonne")  
    public ResponseEntity<PersonneModel> insert_personne(@RequestBody PersonneModel personne){
        
        String nom = personne.getNom();
        String sexe = personne.getSexe();
        Date dtn = personne.getDtn();
        String email = personne.getEmail();
        String pwd = personne.getPwd();
        personne.insert_user(nom, sexe, dtn, email, pwd);
        return ResponseEntity.ok(personne);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/api/Personne/selectPersonnewhere")
    public ResponseEntity<PersonneModel> listPersonnes(@RequestParam String email, @RequestParam String pwd) 
    {
        PersonneModel p = new PersonneModel();
        p = p.select_user(email, pwd);
        return ResponseEntity.ok().body(p); 
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/api/Personne/updatePwd")
    public ResponseEntity<PersonneModel> updatePwd(@RequestBody PersonneModel personne,HttpSession session) {
        // Met à jour le mot de passe
        String pwd = personne.getPwd();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        personne.update_pwd(pwd, loggedInUserId);

        return new ResponseEntity<>(HttpStatus.OK); 
    }
//
    @CrossOrigin(origins = "*")
    @PostMapping("/api/login")
    public String login(@RequestBody PersonneModel personne, HttpSession session) {
        
        String email = personne.getEmail();
        String pwd = personne.getPwd();

        PersonneModel user = new PersonneModel();
        PersonneModel p = user.select_user(email, pwd);
       
        session.setAttribute("loggedInUserId", p.getId_utilisateur());
        return "Connecté avec succès!";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/logout")
    public String logout(HttpSession session) {
        // Supprimez l'id_utilisateur de la personne connectée de la session lors de la déconnexion
        session.invalidate();
        return "Déconnecté avec succès!";
    }


    // @GetMapping("/user")
    // public String getLoggedInUser(HttpSession session) {
    //     // Récupérez l'id_utilisateur de la personne connectée depuis la session
    //     Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");

    //     if (loggedInUserId != null) {
    //         // Utilisez l'id_utilisateur pour obtenir d'autres informations de l'utilisateur depuis la base de données
    //         User loggedInUser = userRepository.findById(loggedInUserId).orElse(null);
    //         return loggedInUser != null ? "Personne connectée : " + loggedInUser.getNom() : "Aucune personne connectée.";
    //     } else {
    //         return "Aucune personne connectée.";
    //     }
    // }


}
