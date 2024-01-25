package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ParcelleModel {
    

    int id_parcelle;
    double dimension;
    int nb_pieds;
    Double prix;

   

    
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
    public int getnb_pieds() {
        return nb_pieds;
    }
    public void setnb_pieds(int nb_pieds) {
        this.nb_pieds = nb_pieds;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    

    public ParcelleModel(int id_parcelle, double dimension, int nb_pieds, Double prix) {
        this.id_parcelle = id_parcelle;
        this.dimension = dimension;
        this.nb_pieds = nb_pieds;
        this.prix = prix;
       
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
                    int nb_pieds = result.getInt(3);
                    Double prix = result.getDouble(4);
                    
                    ParcelleModel p = new ParcelleModel(id_parcelle,dimension,nb_pieds,prix);
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

    public void insert_parcelle(Double dimension , int nb_pieds , Double prix)
    {
        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");
            
             try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                PreparedStatement pstmt = connection.prepareStatement("insert into parcelle(dimension,nb_pieds,prix)values(?,?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setDouble(1, dimension);
                pstmt.setInt(2, nb_pieds);
                pstmt.setDouble(3, prix);
                
                pstmt.executeUpdate();
                System.out.println("insert parcelle sucessfully");
            }
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
