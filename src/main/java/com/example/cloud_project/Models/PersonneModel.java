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
    String email;


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
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public PersonneModel(int id_utilisateur, String nom, String sexe, Date dtn, String pwd, String formatDtn,
            String email) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.sexe = sexe;
        this.dtn = dtn;
        this.pwd = pwd;
        this.formatDtn = formatDtn;
        this.email = email;
    }

    
    public PersonneModel() {
    }

    public PersonneModel(int id_utilisateur , String nom, String sexe, String formatDtn, String email, String pwd) {
        
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.sexe = sexe;
        this.formatDtn = formatDtn;
        this.email = email;
        this.pwd = pwd;
       
       
    }

    public PersonneModel[] list_user()
    {
        List<PersonneModel> resultatList = new ArrayList<>();

        try 
        {
            
                Conn c = new Conn();
                Connection conn = c.getConnex();
                Statement stmnt = conn.createStatement();
                ResultSet result = stmnt.executeQuery("select * from utilisateurs");

                while (result.next()) 
                {
                    int id_utilisateur = result.getInt(1);
                    String nom = result.getString(2);
                    String sexe = result.getString(3);
                    Date dtn = result.getDate(4);
                    String email = result.getString(5);
                    String pwd = result.getString(6);
                    // Format the date using SimpleDateFormat
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDtn = sdf.format(dtn);

                    PersonneModel p = new PersonneModel(id_utilisateur,nom,sexe,formattedDtn,email,pwd);
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

        return resultatList.toArray(new PersonneModel[resultatList.size()]);
    }

    public void insert_user(String nom , String sexe , Date dtn , String email , String pwd)
    {
        try 
        {
                Conn c = new Conn();
                Connection conn = c.getConnex();
               
           
                PreparedStatement pstmt = conn.prepareStatement("insert into utilisateurs(nom,sexe,dtn,email,pwd)values(?,?,?,?,?)");

                pstmt.setString(1,nom);
                pstmt.setString(2, sexe);
                pstmt.setDate(3, dtn);
                pstmt.setString(4, email);
                pstmt.setString(5, pwd);

                pstmt.executeUpdate();
                System.out.println("insert personne sucessfully");

                conn.close();
            
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public PersonneModel select_user(String nom, String pwd) {
        PersonneModel p = null;
        
        try {
            
            Conn c = new Conn();
            Connection conn = c.getConnex();
           
            String sql = "select * from utilisateurs where email = ? and pwd = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
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
                p.setEmail(result.getString(5));
                p.setPwd(result.getString(6));
            }

            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return p;
    }

    public void update_pwd(String pwd , int id_utilisateur)
    {
        try 
        {
            
            Conn c = new Conn();
            Connection conn = c.getConnex();
            
            PreparedStatement pstmt = conn.prepareStatement("update utilisateurs set pwd = ? where id_utilisateur = ?");
                
               
            pstmt.setString(1,pwd);
            pstmt.setInt(2, id_utilisateur);

            pstmt.executeUpdate();
            System.out.println("update pwd sucessfully");
            conn.close();
            
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }

}
