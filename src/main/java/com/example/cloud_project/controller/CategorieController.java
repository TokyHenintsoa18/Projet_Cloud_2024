package com.example.cloud_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.PersonneModel;
import com.example.cloud_project.Models.CategorieModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
 
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategorieController {
    
    @CrossOrigin(origins = "*")
    @GetMapping("/list_categorie")
    public ResponseEntity<CategorieModel[]> listCategories()
    {
       CategorieModel categorie = new CategorieModel();
       CategorieModel[] list_cat = categorie.list_categorie();
       return ResponseEntity.ok().body(list_cat);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/insert_categorie")
    public ResponseEntity<CategorieModel> insertCategorie(@RequestBody CategorieModel categorie) {

        // Vous pouvez accéder aux propriétés directement depuis l'objet categorie
        int rendement_par_pieds = categorie.getRendement_par_pieds();
        Double prix_unitaire = categorie.getPrix_unitaire();
        String nom_categorie = categorie.getNom_categorie();

        // Appel de la fonction `update_categorie()`
        categorie.insert_categorie(rendement_par_pieds, prix_unitaire, nom_categorie);

        // Retour de la catégorie mise à jour
        return ResponseEntity.ok(categorie);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update_categorie")
    public ResponseEntity<CategorieModel> updateCategorie(@RequestBody CategorieModel categorie) {

        int rendement_par_pieds = categorie.getRendement_par_pieds();
        double prix_unitaire = categorie.getPrix_unitaire();
        String nom_categorie = categorie.getNom_categorie();
        int id_categorie = categorie.getId_categorie();

        

        // Appel de la fonction `update_categorie()`
        categorie.update_categorie(rendement_par_pieds, prix_unitaire, nom_categorie, id_categorie);

        // Retour de la catégorie mise à jour
        return ResponseEntity.ok(categorie);
    }
}
