package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.ParcelleModel;
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
}
