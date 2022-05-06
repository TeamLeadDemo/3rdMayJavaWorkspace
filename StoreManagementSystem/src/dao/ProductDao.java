package dao;

import java.util.List;

import exception.EmptyStoreException;
import model.ProductPojo;

public interface ProductDao {

	ProductPojo addProduct(ProductPojo productPojo); // Create
	
	ProductPojo updateProduct(ProductPojo productPojo); // Update
	
	void deleteProduct(int productId); // Delete
	
	List<ProductPojo> getAllProducts()throws EmptyStoreException; // Read
	
	ProductPojo getAProduct(int productId); // Read
	
}
