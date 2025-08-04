
package dao;

import java.sql.*;
import core.Database;
import entity.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDao {
    private Connection connection;

    public UserDao() {
        this.connection = Database.getInstance();
    }
    
    public User findByLogin(String email, String password){
       User user = null;
       String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, email);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){    
                user = this.match(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
       
    }
    public ArrayList<User> findAll(){
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM user");
            while(rs.next()){
                users.add(this.match(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
                
    }
    

    private User match(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getNString("email"));
        user.setPassword(rs.getNString("password"));
        return user;
        
    }
    public boolean create(User user) {
    String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
    try {
        PreparedStatement pr = this.connection.prepareStatement(query);
        pr.setString(1, user.getName());
        pr.setString(2, user.getEmail());
        pr.setString(3, user.getPassword());
        int affectedRows = pr.executeUpdate();
        return affectedRows > 0; // işlem başarılıysa true döner
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}

    
    
    
    
    
    
}
