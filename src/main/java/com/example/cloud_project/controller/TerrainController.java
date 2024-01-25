package com.example.cloud_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cloud_project.Models.TerrainModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.cloud_project.Models.PersonneModel;
@RestController
public class TerrainController {
    
    @GetMapping("Terrain/listsTerrain")
    public String list_terrain()
    {
        TerrainModel t = new TerrainModel();
        TerrainModel list_terrain[]=t.select_terrain();
        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(list_terrain);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    @GetMapping("Terrain/insertTerrain")
    public String insert_personne(@RequestParam("description") String description , @RequestParam("latitude") Long latitude , @RequestParam("longitude") Long longitude , @RequestParam("id_parcelle") int id_parcelle , @RequestParam("photo") String photo)
    {
        TerrainModel terrain = new TerrainModel();
        terrain.insert_terrain(description, latitude, longitude, id_parcelle, photo);
        // Convertir la liste en format JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(terrain);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
   
}