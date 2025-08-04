
package business;

import core.Helper;
import dao.ProductDao;
import entity.Product;
import java.util.ArrayList;

public class ProductController {
    private final ProductDao productDao = new ProductDao();
    
     public ArrayList<Product> findAll(){
        return this.productDao.findAll();
    }
      public Product getById(int id){
        return this.productDao.getById(id);
    }
    public boolean delete(int id){
        if(this.getById(id)==null){
            Helper.showMsg(id + " ");
            return false;
        }return this.productDao.delete(id);
    }
    public boolean save(Product product){
        return this.productDao.save(product);
    }
    public boolean update(Product product){
        if(this.getById(product.getId())==null){
          Helper.showMsg(product.getId()+ "No registered products found.");
          return false;
    }   return this.productDao.update(product);
}
    public ArrayList<Product> filter(String name, String code, Boolean isStock){
        String query = "SELECT * FROM product";
        ArrayList<String> whereList = new ArrayList<>();
        
        if(name != null && !name.trim().isEmpty()){
            whereList.add("name LIKE '%"+ name.trim()+ "%'" );
        }
        if(code != null && !code.trim().isEmpty()){
            whereList.add("code LIKE '%"+ code.trim()+ "%'");
        }
        if (isStock != null) {
        if (isStock) {
            whereList.add("stock > 0");
        } else {
            whereList.add("stock <= 0");
        }
    }
        
        if(!whereList.isEmpty()){
            String whereQuery = String.join(" AND ", whereList);
            query+= " WHERE "+whereQuery;
        }
       
        return this.productDao.query(query);
    }
    
}
