package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.ParcelleModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

import com.example.cloud_project.Models.PersonneModel;
@RestController
@CrossOrigin(origins = "*")
public class ParcelleController {
    
    @GetMapping("/api/Parcelle/lists_parcelle")
    public ResponseEntity<ParcelleModel[]> listParcelles()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel list_parcelle[]=p.select_parcelle();
        return ResponseEntity.ok().body(list_parcelle);
    }

    @GetMapping("/api/Parcelle/information_parcelle_par_terrain_utilisateur")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_utilisateur(
        @RequestParam int id_utlisateur,
        HttpSession session){
        ParcelleModel p = new ParcelleModel();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_utilisateur(loggedInUserId);
        return ResponseEntity.ok().body(stat);
    }

    @GetMapping("/api/Parcelle/information_parcelle_par_terrain_parcelle")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_parcelle(
        @RequestParam int id_parcelle){
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_parcelle(id_parcelle);
        return ResponseEntity.ok().body(stat);
    }

    @GetMapping("/api/Parcelle/information_parcelle_par_terrain_categorie")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_categorie(
        @RequestParam int id_categorie){
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
        return ResponseEntity.ok().body(stat);
    }

    @GetMapping("/api/Parcelle/stat_parcelle")
    public ResponseEntity<ParcelleModel[]> stat_parcelle()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.stat_parcelle();
        return ResponseEntity.ok().body(stat);
    }

    @GetMapping("/api/Parcelle/insert_parcelle")
    public ResponseEntity<ParcelleModel> insert_parcelle(
        @RequestParam Double dimension , 
        @RequestParam int nb_pieds , 
        @RequestParam Double prix)
    {
        ParcelleModel parcelle = new ParcelleModel();
        parcelle.setDimension(dimension);
        parcelle.setNb_pieds(nb_pieds);
        parcelle.setPrix(prix);

        parcelle.insert_parcelle(dimension, nb_pieds, prix);
        return ResponseEntity.ok(parcelle);
    }

    
}
