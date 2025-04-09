package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQL {
    
    private static  Connection connection;
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_NAME", "root", "PASSWORD");
        } catch (Exception e) {
        }
    }

    public static ResultSet execute(String query) throws Exception{
        
            
            Statement statement = connection.createStatement();

            if (query.startsWith("SELECT")) {
                return statement.executeQuery(query);               
            } else {
                statement.executeUpdate(query);
                return null;
            }

       
    }

}
