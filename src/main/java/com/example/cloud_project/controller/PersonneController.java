package com.example.cloud_project.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @GetMapping("Personne/selectPersonne")
    public String selectPersonne(@RequestParam("nom") String nom, @RequestParam("pwd") String pwd) {

    PersonneModel p = new PersonneModel();
    p = p.select_personne(nom, pwd);

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

}
