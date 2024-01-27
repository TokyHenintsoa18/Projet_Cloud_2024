package types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Type {
	
	int id_Type;
    String nom_Type;
    double prix;
    
   public Type(String nom_Type, double prix) {
       this.nom_Type = nom_Type;
       this.prix = prix;
   }
   public Type(int id,String nom_Type, double prix) {
       this.id_Type=id;
       this.nom_Type = nom_Type;
       this.prix = prix;
   }
   
   public double getPrix() {
       return prix;
   }
   public void setPrix(double prix) {
       this.prix = prix;
   }
   public Type() {
   }
   public Type(int id_Type, String nom_Type) {
       this.id_Type = id_Type;
       this.nom_Type = nom_Type;
   }
   public int getId_Type() {
       return id_Type;
   }
   public void setId_Type(int id_Type) {
       this.id_Type = id_Type;
   }
   public String getNom_Type() {
       return nom_Type;
   }
   public void setNom_Type(String nom_Type) {
       this.nom_Type = nom_Type;
   }

   public Type[] liste(Connection co) throws Exception
   {      
       Vector<Type> vect = new Vector<Type>();
       Type[] resListe=null;
       try {
           if(co!=null)
           {
               Statement stmnt = co.createStatement(); 
               String sql = "SELECT * FROM Type";
               ResultSet result = stmnt.executeQuery(sql);
               
                while (result.next()) {
                   int id_Type=result.getInt("id_Type");
                   String nom_Type=result.getString("nom_Type");
                   double prix=result.getDouble("prix_type");
                    
                    Type res = new Type(id_Type, nom_Type,prix);
                    vect.add(res);
                }
                resListe=new Type[vect.size()];
                vect.copyInto(resListe);
                result.close();
                stmnt.close();
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
       return resListe;
   }

   public Type getTypeById(Connection con, int id_Type)
   {
       Type res=null;
       try {
           if(con!=null)
           {
               Statement stmnt = con.createStatement();
                
                String sql = "SELECT * FROM Reservation where id_type=" + id_Type;
                ResultSet result = stmnt.executeQuery(sql);
                while (result.next()) 
                {
                   int id=result.getInt("id_Type");
                   String nom_Type=result.getString("nom_Type");
                   double prix=result.getDouble("prix_type");
                    
                    res = new Type(id, nom_Type,prix);
                   
                }
               
                result.close();
                stmnt.close();
           }

               } catch (Exception e) {
                   e.printStackTrace();
               }
               return res;
       
   }

   public void insertType(Connection con) 
       {
           try {
               String sql = "INSERT INTO TYPE VALUES (default, ?, ?)";
             
               PreparedStatement statement = con.prepareStatement(sql);

               statement.setString(1,this.getNom_Type());
               statement.setDouble(2,this.getPrix());
               statement.executeUpdate();

           } catch (SQLException e)
           {
               System.out.println("Erreur " + e.getMessage());
           }
       }

}
