
package dao;

import java.sql.*;
import core.Database;
import entity.Cart;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartDao {
    private Connection connection;
    private ProductDao productDao;
    private CustomerDao customerDao;

    public CartDao() {
        this.connection = Database.getInstance();
        this.customerDao = new CustomerDao();
        this.productDao = new ProductDao();
    }
    public ArrayList<Cart> findAll(){
        ArrayList<Cart> carts = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM cart");
            while(rs.next()){
                carts.add(this.match(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carts;
                
    }
     private Cart match(ResultSet rs) throws SQLException {
        Cart carts = new Cart();
        carts.setId(rs.getInt("id"));
        carts.setPrice(rs.getInt("price"));
        carts.setCustomerId(rs.getInt("customer_id"));
        carts.setProductId(rs.getInt("product_id"));
        carts.setNote(rs.getString("note"));
        carts.setDate(LocalDate.parse(rs.getString("date")));
        carts.setCustomer(this.customerDao.getById(carts.getCustomerId()));
        carts.setProduct(this.productDao.getById(carts.getProductId()));
        
        return carts;
        
    }
    public boolean save(Cart cart){
        String query = "INSERT INTO cart (customer_id,product_id,price,date,note) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, cart.getCustomerId());
            pr.setInt(2, cart.getProductId());
            pr.setInt(3, cart.getPrice());
            pr.setDate(4, Date.valueOf(cart.getDate()));
            pr.setString(5, cart.getNote());
           return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
