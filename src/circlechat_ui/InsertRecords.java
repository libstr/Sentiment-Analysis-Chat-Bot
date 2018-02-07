/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
import circlechat_ui.SqlConnection;
import java.sql.ResultSet;
import java.sql.Statement;
   
public class InsertRecords {  
   
   public static String name;
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:chatBot.sqlite";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
            return conn;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            return null;
        }  
        
    } 
   
  
    public void insert(String first,String last,String user, String pass) {  
        String sql = "INSERT INTO register(first,last,username,password) VALUES(?,?,?,?)";
        Statement stmt = null;
   
        try{  
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, first );
            pstmt.setString(2, last);  
            pstmt.setString(3, user );  
            pstmt.setString(4, pass);  
            pstmt.executeUpdate();  
            
            
        } catch (SQLException e) {  
            //System.err.println(e.getMessage());  
            e.printStackTrace();
        }  
    }
    
   /* public void selectDB(String user) throws SQLException
  {
      System.out.println(user);
        Statement stmt = null;
        PreparedStatement pstmt = null;
   ResultSet rs = null;
   Connection conn = this.connect();
        String sql = "SELECT first FROM register where username = ?";
        try{  
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            rs = pstmt.executeQuery();
            name = rs.getString("first");
            System.out.println(name);
         
        } catch ( Exception e ) {
          System.out.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
          
        }
        finally{
             rs.close();
          stmt.close();
        }
        
         }*/
    
}