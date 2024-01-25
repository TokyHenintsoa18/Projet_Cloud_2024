package com.example.cloud_project.Models;

import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ParcelleModel {
    

    int id_parcelle;
    double dimension;
    int pides;
    Double prix;
    int id_terrain;

    
    public int getId_parcelle() {
        return id_parcelle;
    }
    public void setId_parcelle(int id_parcelle) {
        this.id_parcelle = id_parcelle;
    }
    public double getDimension() {
        return dimension;
    }
    public void setDimension(double dimension) {
        this.dimension = dimension;
    }
    public int getPides() {
        return pides;
    }
    public void setPides(int pides) {
        this.pides = pides;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getId_terrain() {
        return id_terrain;
    }
    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public ParcelleModel(int id_parcelle, double dimension, int pides, Double prix, int id_terrain) {
        this.id_parcelle = id_parcelle;
        this.dimension = dimension;
        this.pides = pides;
        this.prix = prix;
        this.id_terrain = id_terrain;
    }
    public ParcelleModel() {
    }

    public ParcelleModel[] select_parcelle()
    {
        List<ParcelleModel> resultatList = new ArrayList<>();

        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                Statement stmnt = connection.createStatement();
                ResultSet result = stmnt.executeQuery("select * from parcelle");

                while (result.next()) 
                {
                    int id_parcelle = result.getInt(1);
                    Double dimension = result.getDouble(2);
                    int pieds = result.getInt(3);
                    Double prix = result.getDouble(4);
                    int id_terrain = result.getInt(5);

                    ParcelleModel p = new ParcelleModel(id_parcelle,dimension,pieds,prix,id_terrain);
                    resultatList.add(p);
                }
            }
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return resultatList.toArray(new ParcelleModel[resultatList.size()]);
    }
}
