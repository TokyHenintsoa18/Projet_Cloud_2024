package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TypeModel {

    int id_type;
    String nom_type;

    public TypeModel() {
    }

    public TypeModel(int id_type, String nom_type) {
        this.id_type = id_type;
        this.nom_type = nom_type;
    }


    public int getId_type() {
        return this.id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getNom_type() {
        return this.nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public TypeModel[] list_type()
    {
        List<TypeModel> resultatList = new ArrayList<>();

        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                Statement stmnt = connection.createStatement();
                ResultSet result = stmnt.executeQuery("select * from type");

                while (result.next()) 
                {
                    int id_type = result.getInt(1);
                    String nom_type = result.getString(2);

                    TypeModel t = new TypeModel(id_type, nom_type);
                    resultatList.add(t);
                }
            }
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        return resultatList.toArray(new TypeModel[resultatList.size()]);
    }

public TypeModel select_type_by_id(int id_type, String nom_type) {
    TypeModel t= null;
    
    try {
        String url = "jdbc:postgresql://localhost:5432/culture";
        String utilisateur = "postgres";
        String motDePasse = "root";
        Class.forName("org.postgresql.Driver");
    
        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
        String sql = "select * from type where id_type ="+id_type+"";
        PreparedStatement pstmt = connection.prepareStatement(sql);
    
        pstmt.setInt(1, id_type);
        pstmt.setString(2, nom_type);
    
        ResultSet result = pstmt.executeQuery();
    
        if (result.next()) {
            t= new TypeModel();
            t.setId_type(result.getInt(1));
            t.setNom_type(result.getString(2));
        }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return t;
}

public void insert_type(String nom_type)
{
    try 
    {
        String url = "jdbc:postgresql://localhost:5432/culture";
        String utilisateur = "postgres";
        String motDePasse = "root";
        Class.forName("org.postgresql.Driver");
        
         try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
        {
            PreparedStatement pstmt = connection.prepareStatement("insert into type(nom)values(?)");

            pstmt.setString(1,nom_type);

            pstmt.executeUpdate();
            System.out.println("insert type sucessfully");
        }
        
    }catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
}
}