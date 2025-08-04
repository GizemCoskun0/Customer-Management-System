
package core;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static Database instance = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:mysql://localhost:3306/customermanage";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "gizem2004";

    public Database() {
        try{
            this.connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            
        }catch(SQLException e){
            System.out.println("Error Code: "+ e.getErrorCode());
            System.out.println("Error Message: "+ e.getMessage());
        }
        
    }

    private Connection getConnection() {
        return connection;
    }
    
    public static Connection getInstance(){
        try {
            if(instance==null || instance.getConnection().isClosed()){
                instance = new Database();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance.getConnection();
    }
    
    
    
    
}
