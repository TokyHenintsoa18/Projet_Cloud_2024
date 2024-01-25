package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.cloud_project.Models.PersonneModel;
@RestController
public class ParcelleController {
    
    @GetMapping("Parcelle/listsParcelle")
    public String list_parcelle()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel list_parcelle[]=p.select_parcelle();
        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(list_parcelle);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
