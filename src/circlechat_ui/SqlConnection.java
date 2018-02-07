/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tenzin Tridhe Naga
 */
public class SqlConnection {
    
        public static Connection DbConnector(){
        try{            
            Class.forName("org.sqlite.JDBC");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:sqlite:chatBot.sqlite");
            return conn;
            }catch(ClassNotFoundException | SQLException e){
              System.out.println(e);
              return null;
            } 
        }

    
}
