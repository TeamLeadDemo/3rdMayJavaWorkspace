package service;

import java.util.List;

import exception.EmptyStoreException;
import exception.SystemException;
import model.ProductPojo;

public interface ProductService {

	ProductPojo addProduct(ProductPojo productPojo)throws SystemException ; // Create
	
	ProductPojo updateProduct(ProductPojo productPojo)throws SystemException ; // Update
	
	void deleteProduct(int productId)throws SystemException ; // Delete
	
	List<ProductPojo> getAllProducts()throws EmptyStoreException, SystemException; // Read
	
	ProductPojo getAProduct(int productId)throws SystemException ; // Read
	
}
