package dao;

import java.util.List;

import exception.EmptyStoreException;
import exception.SystemException;
import model.ProductPojo;

public interface ProductDao {

	ProductPojo addProduct(ProductPojo productPojo)throws SystemException; // Create
	
	ProductPojo updateProduct(ProductPojo productPojo)throws SystemException; // Update
	
	void deleteProduct(int productId)throws SystemException; // Delete
	
	List<ProductPojo> getAllProducts()throws EmptyStoreException, SystemException; // Read
	
	ProductPojo getAProduct(int productId)throws SystemException; // Read
	
}
