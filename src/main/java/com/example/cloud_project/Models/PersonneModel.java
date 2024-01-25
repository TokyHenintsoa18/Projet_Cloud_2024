package com.example.cloud_project.Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonneModel {

 

    int id_utilisateur;
    String nom;
    String sexe;
    Date dtn;
    String pwd;
    String formatDtn;

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

    public Date getDtn() {
        return dtn;
    }
    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFormatDtn() {
        return formatDtn;
    }
    public void setFormatDtn(String formatDtn) {
        this.formatDtn = formatDtn;
    }
    


    public PersonneModel(int id_utilisateur, String nom, String sexe, String pwd, String formatDtn) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.sexe = sexe;
        this.pwd = pwd;
        this.formatDtn = formatDtn;
    }

    public PersonneModel() {
    
    }
    
    // public PersonneModel[] list_user()
    // {
    //     List<PersonneModel> resultatList = new ArrayList<>();

    //     try 
    //     {
    //         String url = "jdbc:postgresql://localhost:5432/culture";
    //         String utilisateur = "postgres";
    //         String motDePasse = "root";
    //         Class.forName("org.postgresql.Driver");

    //         try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
    //         {
    //             Statement stmnt = connection.createStatement();
    //             ResultSet result = stmnt.executeQuery("select * from personne");

    //             while (result.next()) 
    //             {
    //                 int id_personne = result.getInt(1);
    //                 String nom = result.getString(2);
    //                 String email = result.getString(3);
    //                 String pwd = result.getString(4);
                    
    //                 PersonneModel categorie = new PersonneModel(id_personne,nom,email,pwd);
    //                 resultatList.add(categorie);
    //             }
    //         }
    //     } 
    //     catch (Exception e) 
    //     {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }

    //     return resultatList.toArray(new PersonneModel[resultatList.size()]);
    // }

    // public PersonneModel select_personne(String email, String pwd) {
    //     PersonneModel p = null;
      
    //     try {
    //       String url = "jdbc:postgresql://localhost:5432/culture";
    //       String utilisateur = "postgres";
    //       String motDePasse = "root";
    //       Class.forName("org.postgresql.Driver");
      
    //       try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
    //         String sql = "select * from personne where email = ? and pwd = ?";
    //         PreparedStatement pstmt = connection.prepareStatement(sql);
      
    //         pstmt.setString(1, email);
    //         pstmt.setString(2, pwd);
      
    //         ResultSet result = pstmt.executeQuery();
      
    //         if (result.next()) {
    //           p = new PersonneModel();
    //           p.setId_personne(result.getInt(1));
    //           p.setNom(result.getString(2));
    //           p.setEmail(result.getString(3));
    //           p.setPwd(result.getString(4));
    //         }
    //       }
    //     } catch (Exception e) {
    //       e.printStackTrace();
    //     }
      
    //     return p;
    //   }

    public PersonneModel[] list_user()
    {
        List<PersonneModel> resultatList = new ArrayList<>();

        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                Statement stmnt = connection.createStatement();
                ResultSet result = stmnt.executeQuery("select * from utilisateurs");

                while (result.next()) 
                {
                    int id_utilisateur = result.getInt(1);
                    String nom = result.getString(2);
                    String sexe = result.getString(3);
                    Date dtn = result.getDate(4);
                    String pwd = result.getString(5);

                    // Format the date using SimpleDateFormat
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDtn = sdf.format(dtn);

                    PersonneModel p = new PersonneModel(id_utilisateur,nom,sexe,pwd,formattedDtn);
                    resultatList.add(p);
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


    public PersonneModel select_personne(String nom, String pwd) {
        PersonneModel p = null;
        
        try {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");
        
            try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
            String sql = "select * from utilisateurs where nom = ? and pwd = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
        
            pstmt.setString(1, nom);
            pstmt.setString(2, pwd);
        
            ResultSet result = pstmt.executeQuery();
        
            if (result.next()) {
                p = new PersonneModel();
                p.setId_utilisateur(result.getInt(1));
                p.setNom(result.getString(2));
                p.setSexe(result.getString(3));
                // Format dtn as a simple date
                Date dtnDate = result.getDate(4);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDtn = simpleDateFormat.format(dtnDate);
                p.setFormatDtn(formattedDtn);

                p.setPwd(result.getString(5));
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return p;
    }

    public void insert_personne(String nom , String sexe , Date dtn , String pwd)
    {
        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");
            
             try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                PreparedStatement pstmt = connection.prepareStatement("insert into utilisateurs(nom,sexe,dtn,pwd)values(?,?,?,?)");
                // pstmt.setInt(1, wallet);
                // pstmt.setInt(2, wallet);
                pstmt.setString(1,nom);
                pstmt.setString(2, sexe);
                pstmt.setDate(3, dtn);
                pstmt.setString(4, pwd);

                pstmt.executeUpdate();
                System.out.println("insert personne sucessfully");
            }
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void update_pwd(String pwd , int id_utilisateur)
    {
        try 
        {
            String url = "jdbc:postgresql://localhost:5432/culture";
            String utilisateur = "postgres";
            String motDePasse = "root";
            Class.forName("org.postgresql.Driver");
            
             try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse))
            {
                PreparedStatement pstmt = connection.prepareStatement("update utilisateurs set pwd = ? where id_utilisateur = ?");
                
               
                pstmt.setString(1,pwd);
                pstmt.setInt(2, id_utilisateur);

                pstmt.executeUpdate();
                System.out.println("update pwd sucessfully");
            }
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }



}
