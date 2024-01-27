package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TerrainModel {
    
    int id_terrain;
    String description;
    long latitude;
    long longitude;
    int id_utilisateur;
    String photo;


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

    public long getLatitude() {
        return this.latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return this.longitude;
    }

    public void setLongitude(long longitude) {
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


    public TerrainModel(int id_terrain, String description, long latitude, long longitude, String photo) {
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
                    long latitude = result.getLong(3);
                    long longitude = result.getLong(4);
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

    public void insert_terrain(String description, long latitude, long longitude, int idParcelle, String photo) {
        try {
                Conn c = new Conn();
                Connection conn = c.getConnex();

            
                String query = "INSERT INTO terrain (description, latitude, longitude, id_parcelle, photo) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setString(1, description);
                    preparedStatement.setLong(2, latitude);
                    preparedStatement.setLong(3, longitude);
                    preparedStatement.setInt(4, idParcelle);
                    preparedStatement.setString(5, photo);
                    preparedStatement.executeUpdate();
                    System.out.println("insert terrain successfully");
                }
                conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
       
    }

    public void insert_parcelle_terrain(int id_utilisateur ,int id_parcelle , int id_terrain , int id_categorie)
    {
        try 
        {
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            
                PreparedStatement pstmt = conn.prepareStatement("insert into parcelle_par_terrain(id_utilisateur,id_parcelle,id_terrain,id_categorie)values(?,?,?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setInt(1, id_utilisateur);
                pstmt.setInt(2, id_parcelle);
                pstmt.setInt(3, id_terrain);
                pstmt.setInt(4, id_categorie);
                pstmt.executeUpdate();
                System.out.println("insert parcelle_terrain sucessfully");
            
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }



}