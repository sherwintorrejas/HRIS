/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;
/**
 *
 * @author USER
 */
public class connector {
    
     private Connection connection;
    
    public connector(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hris", "root", "");
            }catch(SQLException e){
                System.err.println("Cannot connect to database: " + e.getMessage());
            }
        
        
    }
    // FOR DB CONNECTOR CODE 

//for SELECT or DISPLAY data, must be inside the connector class
    public ResultSet getData(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
   
}
