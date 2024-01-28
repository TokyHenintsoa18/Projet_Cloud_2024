package com.example.cloud_project.controller;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class PersonneController {
    
    @GetMapping("/api/Personne/listsPersonne")
    public ResponseEntity<PersonneModel[]> listPersonnes() {
        // Get the list of personnes
        PersonneModel p = new PersonneModel();
        PersonneModel[] personnes = p.list_user();

        // Return a ResponseEntity with the JSON response
        return ResponseEntity.ok().body(personnes);
    }

    @GetMapping("/api/Personne/insertPersonne")  
    public ResponseEntity<PersonneModel> insert_personne(
        String nom , 
        String sexe , 
        Date dtn , 
        String email , 
        String pwd){
        PersonneModel p = new PersonneModel();
        p.setNom(nom);
        p.setSexe(sexe);
        p.setDtn(dtn);
        p.setEmail(email);
        p.setPwd(pwd);

        p.insert_user(nom, sexe, dtn, email, pwd);
        return ResponseEntity.ok(p);
    }

    @GetMapping("/api/Personne/selectPersonne")
    public ResponseEntity<PersonneModel> listPersonnes(@RequestParam String email, @RequestParam String pwd) 
    {

        PersonneModel p = new PersonneModel();
        p = p.select_user(email, pwd);

        
        return ResponseEntity.ok().body(p);
        
    }

    @GetMapping("/api/Personne/updatePwd")
    public ResponseEntity<PersonneModel> updatePwd(
        @RequestParam String pwd, 
        @RequestParam int id_utilisateur) {
        // Met à jour le mot de passe
        PersonneModel personne = new PersonneModel();
        personne.setPwd(pwd);
        personne.setId_utilisateur(id_utilisateur);
        personne.update_pwd(pwd, id_utilisateur);

        return new ResponseEntity<>(HttpStatus.OK); 
    }

    @GetMapping("api/login")
    public String login(@RequestParam String email, @RequestParam String pwd, HttpSession session) {
        
        PersonneModel user = new PersonneModel();
        PersonneModel p = user.select_user(email, pwd);
       
        session.setAttribute("loggedInUserId", p.getId_utilisateur());
        return "Connecté avec succès!";
    }

    @GetMapping("api/logout")
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
