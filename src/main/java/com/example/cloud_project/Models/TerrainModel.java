package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TerrainModel {
    
    int id_terrain;
    String description;
    String latitude;
    String longitude;
    int id_utilisateur;
    String photo;
    int id_type;
    int id_parcelle;
    int id_categorie;


    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public int getId_parcelle() {
        return id_parcelle;
    }
    public void setId_parcelle(int id_parcelle) {
        this.id_parcelle = id_parcelle;
    }

    public int getId_terrain() {
        return this.id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }
    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_type() {
        return id_type;
    }
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }


    public TerrainModel(int id_terrain, String description, String latitude, String longitude, String photo) {
        this.id_terrain = id_terrain;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photo = photo;
    }
    public TerrainModel() {

    }
    
    public TerrainModel[] select_terrain()
    {
        List<TerrainModel> lists = new ArrayList<>();

        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();

            
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from terrain");

                while (result.next()) 
                {
                    int id_terrain = result.getInt(1);
                    String description = result.getString(2);
                    String latitude = result.getString(3);
                    String longitude = result.getString(4);
                    String photo= result.getString(5);
                    TerrainModel t = new TerrainModel(id_terrain,description,latitude, longitude, photo);
                    lists.add(t);
                }

                result.close();
                conn.close();
            
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lists.toArray(new TerrainModel[lists.size()]);
    }

    public void insert_terrain(String description, String latitude, String longitude, String photo) {
        try {
                Conn c = new Conn();
                Connection conn = c.getConnex();

            
                String query = "INSERT INTO terrain (description, latitude, longitude, photo) VALUES (?, ?,  ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setString(1, description);
                    preparedStatement.setString(2, latitude);
                    preparedStatement.setString(3, longitude);
                    preparedStatement.setString(4, photo);
                    
                    preparedStatement.executeUpdate();
                    System.out.println("insert terrain successfully");
                }
                conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
       
    }

    public void insert_parcelle_terrain(int id_utilisateur ,int id_parcelle , int id_terrain , int id_categorie , int id_type)
    {
        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            
                PreparedStatement pstmt = conn.prepareStatement("insert into parcelle_par_terrain(id_utilisateur,id_parcelle,id_terrain,id_categorie,id_type)values(?,?,?,?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setInt(1, id_utilisateur);
                pstmt.setInt(2, id_parcelle);
                pstmt.setInt(3, id_terrain);
                pstmt.setInt(4, id_categorie);
                pstmt.setInt(5,id_type);
                pstmt.executeUpdate();
                System.out.println("insert parcelle_terrain sucessfully");
            
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }



}