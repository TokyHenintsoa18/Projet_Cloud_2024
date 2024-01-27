package com.example.cloud_project.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RendementModel {
    
    int id_utilisateur;
    int dimension;
    int nb_pieds;
    int prix;
    int id_categorie;
    int rendement_par_pieds;
    int prix_unitaire;
    int id_parcelle;
    double montant;
    int id_terrain;
    int id_type;

    public int getId_terrain() {
        return id_terrain;
    }
    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public int getId_type() {
        return id_type;
    }
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }
    
    

    public int getId_parcelle() {
        return id_parcelle;
    }
    public void setId_parcelle(int id_parcelle) {
        this.id_parcelle = id_parcelle;
    }
    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    public int getNb_pieds() {
        return nb_pieds;
    }
    public void setNb_pieds(int nb_pieds) {
        this.nb_pieds = nb_pieds;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
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
    public int getPrix_unitaire() {
        return prix_unitaire;
    }
    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }

    public RendementModel(int id_categorie, int rendement_par_pieds, int prix_unitaire) {
        this.id_categorie = id_categorie;
        this.rendement_par_pieds = rendement_par_pieds;
        this.prix_unitaire = prix_unitaire;
    }
    public RendementModel(int id_parcelle, int dimension, int nb_pieds, int prix) {
        this.id_parcelle = id_parcelle;
        this.dimension = dimension;
        this.nb_pieds = nb_pieds;
        this.prix = prix;
    }
   
    public RendementModel(int id_utilisateur, int nb_pieds, int id_parcelle, double montant) {
        this.id_utilisateur = id_utilisateur;
        this.nb_pieds = nb_pieds;
        this.id_parcelle = id_parcelle;
        this.montant = montant;
    }

    public RendementModel() {
    }
    




    public RendementModel[] select_v_parcelle_where(int id_utilisateur)
    {
        List<RendementModel> resultatList = new ArrayList<>();
        
         try{
                 String url = "jdbc:postgresql://localhost:5432/culture";
                String utilisateur = "postgres";
                String motDePasse = "root";
                Class.forName("org.postgresql.Driver");

                try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
                {
                    String sql = "select * from v_prix_rendement where id_utilisateur="+id_utilisateur+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        int id_terrain = result.getInt(1);
                        int id_parcelle = result.getInt(2);
                        int id_user = result.getInt(3);
                        double montant = result.getDouble(4);
                        int id_categorie = result.getInt(5);
                        int id_type = result.getInt(6);

                        RendementModel filtre = new RendementModel();
                        filtre.setId_terrain(id_terrain);
                        filtre.setId_parcelle(id_parcelle);
                        filtre.setId_utilisateur(id_user);
                        filtre.setMontant(montant);
                        filtre.setId_categorie(id_categorie);
                        filtre.setId_type(id_type);
                        resultatList.add(filtre);
                    }

                    result.close();
                    pstmt.close();
                    connection.close();
                } 
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new RendementModel[resultatList.size()]);
    }



}
