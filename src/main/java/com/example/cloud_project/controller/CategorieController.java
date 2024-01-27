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

    @GetMapping("/api/categories/update")
    public ResponseEntity<CategorieModel> updateCategorie(
            @RequestParam int rendementParPieds,
            @RequestParam double prixUnitaire,
            @RequestParam String nomCategorie,
            @RequestParam int idCategorie) {

        // Récupération des valeurs des paramètres
        CategorieModel categorie = new CategorieModel();
        categorie.setRendement_par_pieds(rendementParPieds);
        categorie.setPrix_unitaire(prixUnitaire);
        categorie.setNom_categorie(nomCategorie);
        categorie.setId_categorie(idCategorie);

        // Appel de la fonction `update_categorie()`
        categorie.update_categorie(rendementParPieds, prixUnitaire, nomCategorie, idCategorie);

        // Retour de la catégorie mise à jour
        return ResponseEntity.ok(categorie);
    }
}
