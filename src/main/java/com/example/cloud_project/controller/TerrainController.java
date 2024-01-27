package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cloud_project.Models.TerrainModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.cloud_project.Models.PersonneModel;
@RestController
public class TerrainController {
    
    @GetMapping("Terrain/listsTerrain")
    public ResponseEntity<TerrainModel[]> list_terrain()
    {
        TerrainModel t = new TerrainModel();
        TerrainModel list_terrain[]=t.select_terrain();
        return ResponseEntity.ok().body(list_terrain);
    }

    @PostMapping("Terrain/insertTerrain")
    @ResponseStatus(HttpStatus.OK)
    public void insert_personne(@RequestParam("description") String description , @RequestParam("latitude") Long latitude , @RequestParam("longitude") Long longitude , @RequestParam("id_parcelle") int id_parcelle , @RequestParam("photo") String photo)
    {
        TerrainModel terrain = new TerrainModel();
        terrain.insert_terrain(description, latitude, longitude, id_parcelle, photo);
    }

    @PostMapping("Terrain/insert_parcelle_terrain")
    public void insert_personne(@RequestParam("id_utilisateur") int id_utilisateur,@RequestParam("id_parcelle") int id_parcelle , @RequestParam("id_terrain") int id_terrain , @RequestParam("id_categorie") int id_categorie)
    {
        TerrainModel terrain = new TerrainModel();
       terrain.insert_parcelle_terrain(id_utilisateur,id_parcelle, id_terrain ,id_categorie);
    }
   
}