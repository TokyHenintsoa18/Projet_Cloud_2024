package com.example.cloud_project.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneModel {
    

    int id_personne;
    String nom;
    String email;
    String pwd;
    
    public int getId_personne() {
        return id_personne;
    }
    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public PersonneModel(int id_personne, String nom, String email, String pwd) {
        this.id_personne = id_personne;
        this.nom = nom;
        this.email = email;
        this.pwd = pwd;
    }

    public PersonneModel() {
    
    }
    
    public PersonneModel[] list_user()
    {
        List<PersonneModel> resultatList = new ArrayList<>();

        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                Statement stmnt = connection.createStatement();
                ResultSet result = stmnt.executeQuery("select * from personne");

                while (result.next()) 
                {
                    int id_personne = result.getInt(1);
                    String nom = result.getString(2);
                    String email = result.getString(3);
                    String pwd = result.getString(4);
                    
                    PersonneModel categorie = new PersonneModel(id_personne,nom,email,pwd);
                    resultatList.add(categorie);
                }
            }
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return resultatList.toArray(new PersonneModel[resultatList.size()]);
    }
}
