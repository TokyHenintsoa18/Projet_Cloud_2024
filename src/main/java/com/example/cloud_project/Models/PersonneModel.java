package com.example.cloud_project.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneModel {
    

    int id_utilisateur;
    String nom;
    String sexe;
    Date date;
    
    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public PersonneModel(int id_utilisateur, String nom, String sexe, Date date) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.sexe = sexe;
        this.date = date;
    }
    public PersonneModel() {
    }

    public PersonneModel[] list_personne()
    {
        List<PersonneModel> resultatList = new ArrayList<>();

        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "123";
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                Statement stmnt = connection.createStatement();
                ResultSet result = stmnt.executeQuery("select * from utilisateur");

                while (result.next()) 
                {
                    int id_utilisateur = result.getInt(1);
                    String nom = result.getString(2);
                    String sexe = result.getString(3);
                    Date date = result.getDate(4);
                    
                    PersonneModel categorie = new PersonneModel(id_utilisateur,nom,sexe,date);
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
