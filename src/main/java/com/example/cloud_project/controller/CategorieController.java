package com.example.cloud_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.PersonneModel;
import com.example.cloud_project.Models.CategorieModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CategorieController {
    
    @GetMapping("Categorie/list_categorie")
    public ResponseEntity<CategorieModel[]> listCategories()
    {
       CategorieModel categorie = new CategorieModel();
       CategorieModel[] list_cat = categorie.list_categorie();
       return ResponseEntity.ok().body(list_cat);
    }

    @PostMapping("Categorie/insertCategorie")
    @ResponseStatus(HttpStatus.OK)
    public void insert_categorie_culture(@RequestParam("rendement_par_pieds") int rendement_par_pieds , @RequestParam("prix_unitaire") int prix_unitaire , @RequestParam("nom_categorie") String nom_categorie)
    {
        CategorieModel c = new CategorieModel();
        c.insert_categorie(rendement_par_pieds, prix_unitaire,nom_categorie);
    }

    @PostMapping("Categorie/updateCategorie")
    public void update_categorie_culture(@RequestParam("id_categorie") int id_categorie, @RequestParam("new_rendement_par_pieds") int new_rendement_par_pieds, @RequestParam("new_prix_unitaire") int new_prix_unitaire , @RequestParam("nom_categorie") String nom_categorie) {

        CategorieModel c = new CategorieModel();
        c.update_categorie(id_categorie, new_rendement_par_pieds, new_prix_unitaire,nom_categorie);
    }
}
