package com.example.cloud_project.Models;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategorieModel {

    int id_categorie;
    int rendement_par_pieds;
    int prix_unitaire;
    
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public int getRendement_par_pieds() {
        return rendement_par_pieds;
    }
    public void setRendement_par_pieds(int rendement_par_pieds) {
        this.rendement_par_pieds = rendement_par_pieds;
    }
    public int getprix_unitaire() {
        return prix_unitaire;
    }
    public void setprix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public CategorieModel(int id_categorie, int rendement_par_pieds, int prix_unitaire) {
        this.id_categorie = id_categorie;
        this.rendement_par_pieds = rendement_par_pieds;
        this.prix_unitaire = prix_unitaire;
    }
    public CategorieModel() {

    }

    public CategorieModel[] list_categorie()
    {
        List<CategorieModel> resultatList = new ArrayList<>();

        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                Statement stmnt = connection.createStatement();
                ResultSet result = stmnt.executeQuery("select * from Categorie_culture");

                while (result.next()) 
                {
                    int id_categorie = result.getInt(1);
                    int rendement_par_pieds = result.getInt(2);
                    int prix_unitaire = result.getInt(3);
                    
                    CategorieModel p = new CategorieModel(id_categorie,rendement_par_pieds,prix_unitaire);
                    resultatList.add(p);
                }
            }
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return resultatList.toArray(new CategorieModel[resultatList.size()]);
    }

    public void insert_categorie(int rendement_par_pieds, int prix_unitaire)
    {
        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");
            
             try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                PreparedStatement pstmt = connection.prepareStatement("insert into Categorie_culture(rendement_par_pieds,Prix_unitaire)values(?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setInt(1, rendement_par_pieds);
                pstmt.setInt(2, Prix_unitaire);
                
                pstmt.executeUpdate();
                System.out.println("insert categorie sucessfully");
            }
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public CategorieModel select_categorie_by_id(int id_categorie, int rendement_par_pieds, int prix_unitaire) {
        CategorieModel c = null;
        
        try {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");
        
            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
            String sql = "select * from Categorie_culture where id_categorie ="+id_categorie+"";
            PreparedStatement pstmt = connection.prepareStatement(sql);
        
            pstmt.setInt(1, id_categorie);
            pstmt.setInt(2, rendement_par_pieds);
            pstmt.setInt(3, prix_unitaire);
        
            ResultSet result = pstmt.executeQuery();
        
            if (result.next()) {
                c = new CategorieModel();
                c.setId_categorie(result.getInt(1));
                c.setRendement_par_pieds(result.getInt(2));
                c.setprix_unitaire(result.getInt(3));

            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return t;
    }
}
