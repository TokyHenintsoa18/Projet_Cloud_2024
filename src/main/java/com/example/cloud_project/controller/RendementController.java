package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.RendementModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RendementController {
    @GetMapping("Rendement/nb_pieds_rendement")
    public String list_parcelle(@RequestParam("id_utilisateur") int id_utilisateur)
    {
        RendementModel r = new RendementModel();
        RendementModel[] nb_pieds = r.rend_tot_parcelle(id_utilisateur);
        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(nb_pieds);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
