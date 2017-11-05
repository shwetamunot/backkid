package niit.com.Dao;

import java.util.List;


import niit.com.model.Product;

public interface ProductDao {
public boolean addProduct(Product product);
public List<Product> retrieveProduct();
public boolean deleteProduct(Product product);
public Product getProduct(int proId);
public boolean UpdateProduct(Product product);
}
