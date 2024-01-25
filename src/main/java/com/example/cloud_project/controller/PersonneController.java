package com.example.cloud_project.controller;
import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

import com.example.cloud_project.Models.PersonneModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {
    
    @GetMapping("Personne/listsPersonne")
    public String listPersonnes() {
        // Appel de la méthode list_personne() pour obtenir la liste des personnes
        PersonneModel p = new PersonneModel();
        PersonneModel[] personnes = p.list_user();

        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(personnes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    @GetMapping("/Personne/insertPersonne")
    public String insertPersonne(@RequestParam("nom") String nom, @RequestParam("sexe") String sexe , @RequestParam("dtn") Date dtn,@RequestParam("email") String email , @RequestParam("pwd") String pwd) 
    {
        PersonneModel personne = new PersonneModel();
        personne.insert_user(nom, sexe, dtn,email, pwd);

        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(personne);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    @GetMapping("Personne/selectPersonne")
    public String selectPersonneWhere(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {

    PersonneModel p = new PersonneModel();
    p = p.select_user(email, pwd);

    // Convertir la liste en format JSON
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonResult = "";
    try {
        jsonResult = objectMapper.writeValueAsString(p);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }

    return jsonResult;
    }



    @GetMapping("/Personne/updatePwd")
    public String updatePwd(@RequestParam("id_utilisateur") int id_utilisateur , @RequestParam("pwd") String pwd)
    {
        PersonneModel personne = new PersonneModel();
        personne.update_pwd(pwd, id_utilisateur);

        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(personne);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    // @GetMapping("/Personne/session")
    // public String session_servlet(HttpServletRequest request , )

}
