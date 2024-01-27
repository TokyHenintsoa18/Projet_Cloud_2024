package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.cloud_project.Models.PersonneModel;
@RestController
public class ParcelleController {
    
    @GetMapping("Parcelle/listsParcelle")
    public ResponseEntity<ParcelleModel[]> listParcelles()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel list_parcelle[]=p.select_parcelle();
        return ResponseEntity.ok().body(list_parcelle);
    }

    @PostMapping("Parcelle/insertParcelle")
    @ResponseStatus(HttpStatus.OK)
    public void insert_parcellle(@RequestParam("dimension") Double dimension , @RequestParam("nb_pieds") int nb_pieds , @RequestParam("prix") Double prix)
    {
        ParcelleModel insert_parcelle = new ParcelleModel();
        insert_parcelle.insert_parcelle(dimension, nb_pieds, prix);
    }

    
}
