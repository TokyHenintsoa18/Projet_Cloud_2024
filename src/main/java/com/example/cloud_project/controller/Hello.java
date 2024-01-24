package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Hello {
    
    @GetMapping("/hello")
    public String hello() {
        return "hey";
    }

    // @GetMapping("/list")
    // public String listPersonnes() {
    //     // Appel de la méthode list_personne() pour obtenir la liste des personnes
    //     PersonneModel p = new PersonneModel();
    //     PersonneModel[] personnes = p.list_personne();

    //     // Convertir la liste en format JSON
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     String jsonResult = "";
    //     try {
    //         jsonResult = objectMapper.writeValueAsString(personnes);
    //     } catch (JsonProcessingException e) {
    //         e.printStackTrace();
    //     }

    //     return jsonResult;
    // }


}