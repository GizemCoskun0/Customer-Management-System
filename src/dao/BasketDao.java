
package dao;
import java.sql.*;
import core.Database;
import entity.Basket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasketDao {
    private Connection connection;
    private ProductDao productDao;

    public BasketDao() {
        this.connection = Database.getInstance();
        this.productDao = new ProductDao();
       
    }
     public ArrayList<Basket> findAll(){
        ArrayList<Basket> baskets = new ArrayList<>();
     
         try {
             ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM basket");
               while(rs.next()){
                baskets.add(this.match(rs));
            }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
   
        return baskets;
                
    }
     public boolean save(Basket basket){
        String query = "INSERT INTO basket (product_id) VALUES (?)";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, basket.getProduct_id());
       
           return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
     private Basket match(ResultSet rs) throws SQLException {
        Basket basket = new Basket();
        basket.setId(rs.getInt("id"));
        basket.setProduct_id(rs.getInt("product_id"));
        basket.setProduct(this.productDao.getById(rs.getInt("product_id")));
        return basket;
        
    }
   
     public boolean clear(){
        String query = "DELETE FROM basket";
        try{
            PreparedStatement pr = this.connection.prepareStatement(query);
       
            return pr.executeUpdate() != -1;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    
}
