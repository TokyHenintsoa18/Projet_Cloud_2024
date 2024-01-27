package com.example.cloud_project.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieModel {

    int id_categorie;
    int rendement_par_pieds;
    double prix_unitaire;
    String nom_categorie;
    
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
    
    public double getPrix_unitaire() {
        return prix_unitaire;
    }
    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public CategorieModel(int id_categorie, int rendement_par_pieds, int prix_unitaire,String nom_categorie) {
        this.id_categorie = id_categorie;
        this.rendement_par_pieds = rendement_par_pieds;
        this.prix_unitaire = prix_unitaire;
        this.nom_categorie = nom_categorie;
    }
    public CategorieModel() {

    }

    public CategorieModel[] list_categorie()
    {
        List<CategorieModel> resultatList = new ArrayList<>();

        try 
        {
                Conn c = new Conn();
                Connection conn = c.getConnex();

            
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from Categorie_culture");

                while (result.next()) 
                {
                    int id_categorie = result.getInt(1);
                    int rendement_par_pieds = result.getInt(2);
                    int prix_unitaire = result.getInt(3);
                    String nom_categorie = result.getString(4);
                    
                    CategorieModel p = new CategorieModel(id_categorie,rendement_par_pieds,prix_unitaire,nom_categorie);
                    resultatList.add(p);
                }
                result.close();
            stmnt.close();
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return resultatList.toArray(new CategorieModel[resultatList.size()]);
    }

    public void insert_categorie(int rendement_par_pieds, double prix_unitaire , String nom_categorie)
    {
        try 
        {
            
                Conn c = new Conn();
                Connection conn = c.getConnex();
                
                PreparedStatement pstmt = conn.prepareStatement("insert into Categorie_culture(rendement_par_pieds,Prix_unitaire,nom_categorie)values(?,?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setInt(1, rendement_par_pieds);
                pstmt.setDouble(2, prix_unitaire);
                pstmt.setString(3, nom_categorie);
                
                pstmt.executeUpdate();
                System.out.println("insert categorie sucessfully");
                conn.close();
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public CategorieModel select_categorie_by_id(int id_categorie) {
        CategorieModel cat = null;
        
        try {
            
        
            Conn c = new Conn();
            Connection conn = c.getConnex();
            String sql = "select * from Categorie_culture where id_categorie ="+id_categorie+"";
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
            pstmt.setInt(1, id_categorie);
            
        
            ResultSet result = pstmt.executeQuery();
        
            if (result.next()) {
                cat = new CategorieModel();
                cat.setId_categorie(result.getInt(1));
                cat.setRendement_par_pieds(result.getInt(2));
                cat.setPrix_unitaire(result.getInt(3));
                cat.setNom_categorie(result.getString(4));
                System.out.println("select categorie by id sucessfully");

            }
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cat;
    }

    public void update_categorie(int rendement_par_pieds, double prix_unitaire , String nom_categorie,int id_categorie) {
        try 
        {
            
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            PreparedStatement pstmt = conn.prepareStatement("update categorie_culture set rendement_par_pieds=?,prix_unitaire=?,nom_categorie=? where id_categorie=?");
            
            pstmt.setInt(1,rendement_par_pieds);
            pstmt.setDouble(2, prix_unitaire);
            pstmt.setString(3, nom_categorie);
            pstmt.setInt(4, id_categorie);

            pstmt.executeUpdate();
            System.out.println("update pwd sucessfully");
            conn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
