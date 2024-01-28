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
    String nom_categorie;
    String nom_type;
    int sum_montant;

    public int getSum_montant() {
        return sum_montant;
    }

    public void setSum_montant(int sum_montant) {
        this.sum_montant = sum_montant;
    }

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

    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getNom_type() {
        return nom_type;
    }
    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }
    
    public RendementModel() {
    }
    




    public RendementModel[] v_prix_rendement_prevision_where(int id_utilisateur)
    {
        List<RendementModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_prix_rendement_prevision where id_utilisateur="+id_utilisateur+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        int id_terrain = result.getInt(1);
                        int id_parcelle = result.getInt(2);
                        int id_user = result.getInt(3);
                        int nb_pieds = result.getInt(4);
                        double montant = result.getDouble(5);
                        int id_categorie = result.getInt(6);
                        String nom_categorie = result.getString(7);
                        int id_type = result.getInt(8);
                        String nom_type = result.getString(9);


                        RendementModel filtre = new RendementModel();
                        filtre.setId_terrain(id_terrain);
                        filtre.setId_parcelle(id_parcelle);
                        filtre.setId_utilisateur(id_user);
                        filtre.setNb_pieds(nb_pieds);
                        filtre.setMontant(montant);
                        filtre.setId_categorie(id_categorie);
                        filtre.setNom_categorie(nom_categorie);
                        filtre.setId_type(id_type);
                        filtre.setNom_type(nom_type);
                        resultatList.add(filtre);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new RendementModel[resultatList.size()]);
    }

    public RendementModel[] v_sum_prix_rendement_prevision(int id_utilisateur)
    {
        List<RendementModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_sum_prix_rendement_prevision where id_utilisateur="+id_utilisateur+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_user = result.getInt(1);
                        int sum_montant = result.getInt(2);


                        RendementModel filtre = new RendementModel();
                        
                        filtre.setId_utilisateur(id_user);
                        filtre.setMontant(sum_montant);
                        resultatList.add(filtre);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new RendementModel[resultatList.size()]);
    }


    public RendementModel[] v_rendement_par_qte(int id_utilisateur)
    {
        List<RendementModel> resultatList = new ArrayList<>();
        
         try{
                 
                    Conn c = new Conn();
                    Connection conn = c.getConnex();
                        
                    String sql = "select * from v_rendement_par_qte where id_utilisateur="+id_utilisateur+"";
                    System.out.println(sql);
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                   
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) 
                    {
                        
                        int id_terrain = result.getInt(1);
                        int id_user = result.getInt(2);
                        int sum_montant = result.getInt(3);

                        RendementModel filtre = new RendementModel();
                        
                        filtre.setId_utilisateur(id_terrain);
                        filtre.setId_utilisateur(id_user);
                        filtre.setSum_montant(sum_montant);
                        
                        resultatList.add(filtre);
                    }

                    result.close();
                    pstmt.close();
                    conn.close();
                
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        return resultatList.toArray(new RendementModel[resultatList.size()]);
    }





}
