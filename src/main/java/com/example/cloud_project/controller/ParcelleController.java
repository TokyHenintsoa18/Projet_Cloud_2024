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
    @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/lists_parcelle")
    public ResponseEntity<ParcelleModel[]> listParcelles()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel list_parcelle[]=p.select_parcelle();
        return ResponseEntity.ok().body(list_parcelle);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/listParcelleterrain")
    public ResponseEntity<ParcelleModel[]> listParcelleterrain()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel list_parcelle[]=p.v_information_parcelle_par_terrain();
        return ResponseEntity.ok().body(list_parcelle);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/information_parcelle_par_terrain_utilisateur")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_utilisateur(
        @RequestParam int id_utlisateur,
        HttpSession session){
        ParcelleModel p = new ParcelleModel();
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_utilisateur(loggedInUserId);
        return ResponseEntity.ok().body(stat);
    }
  @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/information_parcelle_par_terrain_parcelle")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_parcelle(
        @RequestParam int id_parcelle){
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_parcelle(id_parcelle);
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/information_parcelle_par_terrain_categorie")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_categorie(
        @RequestParam int id_categorie){
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/filtre_nom")
    public ResponseEntity<ParcelleModel[]> v_information_parcelle_par_terrain_par_nom(
        @RequestParam String nom){
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_nom(nom);
        System.out.println("test nom bien");
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/filtre")
    public ResponseEntity<ParcelleModel[]> filtre_v_information_parcelle_par_terrain(@RequestParam Integer id_categorie,@RequestParam Integer id_type){
        ParcelleModel p = new ParcelleModel();
        // ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
        // return ResponseEntity.ok().body(stat);

        if(id_type == null && id_categorie == null || id_type == 0 && id_categorie == 0)
        {
            
            ParcelleModel stat[] = p.v_information_parcelle_par_terrain();
            System.out.println("test");
            return ResponseEntity.ok().body(stat);
        }
        if(id_categorie ==null || id_categorie == 0)
        {
            ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_type(id_type);
            System.out.println("test1");
            return ResponseEntity.ok().body(stat);
        }
        if(id_type ==null || id_type ==0)
        {
            ParcelleModel stat[]=p.v_information_parcelle_par_terrain_par_categorie(id_categorie);
            System.out.println("test2");
            return ResponseEntity.ok().body(stat);
        }

        else
        {
            // Autres cas non pris en charge
            return ResponseEntity.badRequest().body(new ParcelleModel[0]);
        }
    }

  @CrossOrigin(origins = "*")
    @GetMapping("/api/Parcelle/stat_parcelle")
    public ResponseEntity<ParcelleModel[]> stat_parcelle()
    {
        ParcelleModel p = new ParcelleModel();
        ParcelleModel stat[]=p.stat_parcelle();
        return ResponseEntity.ok().body(stat);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/Parcelle/insert_parcelle")
    public ResponseEntity<ParcelleModel> insert_parcelle(@RequestBody ParcelleModel parcelle)
    {
        double dimension = parcelle.getDimension();
        int nb_pieds = parcelle.getNb_pieds();
        double prix = parcelle.getPrix();

        parcelle.insert_parcelle(dimension, nb_pieds, prix);
        return ResponseEntity.ok(parcelle);
    }

    
}
