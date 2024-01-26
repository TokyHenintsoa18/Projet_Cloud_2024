package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.CategorieModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CategorieController {
    
    @GetMapping("Categorie/list_categorie")
    public String list_Categorie()
    {
       CategorieModel categorie = new CategorieModel();
       CategorieModel[] list_cat = categorie.list_categorie();
        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(list_cat);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    @GetMapping("Categorie/insertCategorie")
    public String insert_categorie_culture(@RequestParam("rendement_par_pieds") int rendement_par_pieds , @RequestParam("prix_unitaire") int prix_unitaire)
    {
        CategorieModel c = new CategorieModel();
        c.insert_categorie(rendement_par_pieds, prix_unitaire);

        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
