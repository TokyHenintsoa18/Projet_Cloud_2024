package com.example.cloud_project.controller;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

import com.example.cloud_project.Models.PersonneModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {
    
    @GetMapping("Personne/listsPersonne")
    public ResponseEntity<PersonneModel[]> listPersonnes() {
        // Get the list of personnes
        PersonneModel p = new PersonneModel();
        PersonneModel[] personnes = p.list_user();

        // Return a ResponseEntity with the JSON response
        return ResponseEntity.ok().body(personnes);
    }

    @PostMapping("/Personne/insertPersonne")
    @ResponseStatus(HttpStatus.OK)
    public void insert_personne(String nom , String sexe , Date dtn , String email , String pwd)
    {
        PersonneModel p = new PersonneModel();
        p.insert_user(nom, sexe, dtn, email, pwd);
    }

    @GetMapping("Personne/selectPersonne")
    public ResponseEntity<PersonneModel> listPersonnes(@RequestParam("email") String email, @RequestParam("pwd") String pwd) 
    {

        PersonneModel p = new PersonneModel();
        p = p.select_user(email, pwd);

        
        return ResponseEntity.ok().body(p);
        
    }

    @PostMapping("Personne/updatePwd")
    public ResponseEntity<Void> updatePwd(String pwd, int id_utilisateur) {
        // Met à jour le mot de passe
        PersonneModel personne = new PersonneModel();
        personne.update_pwd(pwd, id_utilisateur);

        return new ResponseEntity<>(HttpStatus.OK); // Ou un code d'état personnalisé
    }

    // @GetMapping("/Personne/session")
    // public String session_servlet(HttpServletRequest request , )

}
