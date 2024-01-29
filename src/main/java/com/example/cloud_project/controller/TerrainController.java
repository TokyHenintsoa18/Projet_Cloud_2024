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

import com.example.cloud_project.Models.TerrainModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

import com.example.cloud_project.Models.PersonneModel;
@RestController
@CrossOrigin(origins = "*")
public class TerrainController {
    
    @GetMapping("/api/Terrain/listsTerrain")
    public ResponseEntity<TerrainModel[]> list_terrain()
    {
        TerrainModel t = new TerrainModel();
        TerrainModel list_terrain[]=t.select_terrain();
        return ResponseEntity.ok().body(list_terrain);
    }

    @GetMapping("/api/Terrain/insertTerrain")
    public ResponseEntity<TerrainModel> insertTerrain(
        @RequestParam String description , 
        @RequestParam String latitude , 
        @RequestParam String longitude , 
        @RequestParam String photo)
    {
        TerrainModel terrain = new TerrainModel();
        terrain.setDescription(description);
        terrain.setLatitude(latitude);
        terrain.setLongitude(longitude);
        terrain.setPhoto(photo);
        terrain.insert_terrain(description, latitude, longitude, photo);
        return ResponseEntity.ok(terrain);
    }

    @GetMapping("/api/Terrain/insert_parcelle_terrain")
    public ResponseEntity<TerrainModel> insert_parcelle_terrain(
        @RequestParam int id_utilisateur,
        @RequestParam int id_parcelle , 
        @RequestParam int id_terrain , 
        @RequestParam int id_categorie,
        @RequestParam int id_type,
        HttpSession session)    
    {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        TerrainModel terrain = new TerrainModel();
        terrain.setId_utilisateur(id_utilisateur);
        terrain.setId_parcelle(id_parcelle);
        terrain.setId_terrain(id_terrain);
        terrain.setId_categorie(id_categorie);
        terrain.setId_type(id_type);
    
       terrain.insert_parcelle_terrain(id_utilisateur,id_parcelle, id_terrain ,id_categorie,id_type);
       return ResponseEntity.ok(terrain);
    }
   
}