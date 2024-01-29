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

import com.example.cloud_project.Models.TypeModel;
import com.example.cloud_project.Models.CategorieModel;
import com.example.cloud_project.Models.PersonneModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.cloud_project.Models.PersonneModel;
@RestController
@CrossOrigin(origins = "*")
public class TypeController {
    @CrossOrigin(origins = "*")
    @GetMapping("/api/Type/list_types")
    public ResponseEntity<TypeModel[]> list_type_culture()
    {
        TypeModel p = new TypeModel();
        TypeModel list_type_culture[]=p.list_type();
        return ResponseEntity.ok().body(list_type_culture);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/api/Type/insert_types")
   
    public  ResponseEntity<TypeModel> insert_type_culture(@RequestBody TypeModel type)
    {
        String nom_type = type.getNom_type();


        type.insert_type(nom_type);
        return ResponseEntity.ok(type);
    }

}