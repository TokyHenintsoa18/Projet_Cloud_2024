package com.example.cloud_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.PersonneModel;
import com.example.cloud_project.Models.RendementModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RendementController {
    
    @GetMapping("Rendement/v_prix_rendement")
    public ResponseEntity<RendementModel[]> insert_parcellle(@RequestParam("id_utilisateur") int id_utilisateur)
    {
        RendementModel r = new RendementModel();
        RendementModel rend_Model[] = r.select_v_parcelle_where(id_utilisateur);
        return ResponseEntity.ok().body(rend_Model);
    }
}
