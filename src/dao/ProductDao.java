
package dao;

import core.Database;
import entity.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
     private Connection connection;

    public ProductDao() {
        this.connection = Database.getInstance();
    }
    public ArrayList<Product> findAll(){
        ArrayList<Product> products = new ArrayList<>();
     
         try {
             ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM product");
               while(rs.next()){
                products.add(this.match(rs));
            }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
   
        return products;
                
    }
    private Product match(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setCode(rs.getString("code"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        
        return product;
        
    }
     public Product getById(int id){
        Product product =null;
        String query = "SELECT*FROM product WHERE id = ?";
       
            PreparedStatement pr;
         try {
             pr = this.connection.prepareStatement(query);
              pr.setInt(1, id);
            ResultSet rs =pr.executeQuery();
            if(rs.next()){
                product = this.match(rs);
            }
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return product;
    }
     public boolean delete(int id){
        String query = "DELETE FROM product Where id = ?";
        try{
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
      public boolean save(Product product){
        String query = "INSERT INTO product (name,code,price,stock) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, product.getName());
            pr.setString(2, product.getCode());
            pr.setString(3, String.valueOf(product.getPrice()));
            pr.setString(4, String.valueOf(product.getStock()));
           return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean update(Product product){
                String query = "UPDATE product SET name = ?, code = ?, price = ?, stock = ? WHERE id = ?";

        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1, product.getName());
            pr.setString(2, product.getCode());
            pr.setString(3, String.valueOf(product.getPrice()));
            pr.setString(4, String.valueOf(product.getStock()));
            pr.setInt(5, product.getId());
           return pr.executeUpdate() != -1;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return true;
        
    }
     public ArrayList<Product> query(String query){
        ArrayList<Product> products = new ArrayList<>();
        
        ResultSet rs;
        try {
            rs = this.connection.createStatement().executeQuery(query);
            while(rs.next()){
            products.add(this.match(rs));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        
        }
        return products;
    }
}
