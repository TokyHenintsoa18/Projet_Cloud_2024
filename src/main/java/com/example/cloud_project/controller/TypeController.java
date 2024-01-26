package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cloud_project.Models.TypeModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.cloud_project.Models.PersonneModel;
@RestController
public class TypeController {
    
    @GetMapping("Type/list_types")
    public String list_type_culture()
    {
        TypeModel p = new TypeModel();
        TypeModel list_type_culture[]=p.select_parcelle();
        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(list_type_culture);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    @GetMapping("Parcelle/insert_types")
    public String insert_type_culture(@RequestParam("nom_type") String nom_type)
    {
        TypeModel t = new TypeModel();
        insert_type.insert_type_culture(nom_type);

        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(insert_type_culture);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

}