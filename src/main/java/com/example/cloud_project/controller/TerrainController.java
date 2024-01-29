package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @CrossOrigin(origins = "*")
    @GetMapping("/api/Terrain/listsTerrain")
    public ResponseEntity<TerrainModel[]> list_terrain()
    {
        TerrainModel t = new TerrainModel();
        TerrainModel list_terrain[]=t.select_terrain();
        return ResponseEntity.ok().body(list_terrain);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/api/Terrain/insertTerrain")
    public ResponseEntity<TerrainModel> insertTerrain(@RequestBody TerrainModel terrain)
    {
        String description = terrain.getDescription();
        String longitude = terrain.getLongitude();
        String latitude = terrain.getLatitude();
        String photo = terrain.getPhoto();
        terrain.insert_terrain(description, latitude, longitude, photo);
        return ResponseEntity.ok(terrain);
    }

    

    @CrossOrigin(origins = "*")
    @PostMapping("/api/Terrain/insert_parcelle_terrain")
    public ResponseEntity<TerrainModel> insert_parcelle_terrain(@RequestBody TerrainModel terrain,HttpSession session)    
    {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        int id_parcelle = terrain.getId_parcelle();
        int id_terrain = terrain.getId_terrain();
        int id_categorie = terrain.getId_categorie();
        int id_type = terrain.getId_type();
    
       terrain.insert_parcelle_terrain(loggedInUserId,id_parcelle, id_terrain ,id_categorie,id_type);
       return ResponseEntity.ok(terrain);
    }
   
}