/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import circlechat_ui.SqlConnection;

/**
 *
 * @author Tenzin Tridhe Naga
 */
public final class loginModel {
    
    Connection conn;
    public loginModel(){
        conn = SqlConnection.DbConnector();
        if(conn == null)
            System.exit(1);
        else
            isDbConnected();
    }
    public boolean isDbConnected(){
        try{
            return conn.isClosed();
        }catch(SQLException e)
        {
            return false;
        }
    }    
    public boolean isLogin(String user, String pass) throws SQLException{
        PreparedStatement preparedStatement = null;
        System.out.println("I am here");
        ResultSet resultSet = null;
        String query = "select * from register where username = ? and password  = ?";
        try{
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                System.out.println("Reached");
                return true;
            }
            else
                return false;
        }catch (Exception e){
            return false;
            
        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
    }
    
}
