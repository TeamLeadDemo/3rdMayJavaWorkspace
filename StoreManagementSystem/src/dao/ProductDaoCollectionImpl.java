package dao;

import java.util.ArrayList;
import java.util.List;

import model.ProductPojo;

public class ProductDaoCollectionImpl implements ProductDao{
	
	// this is the data store
	List<ProductPojo> allProducts = new ArrayList<ProductPojo>();

	public ProductDaoCollectionImpl() {
		ProductPojo product1 = new ProductPojo(101, "Apples", "Tasty Juicy Apples!", 10, "");
		ProductPojo product2 = new ProductPojo(102, "Bananas", "Delecious Bananas!", 8, "");
		ProductPojo product3= new ProductPojo(103, "Oranges", "Juicy Oranges!", 5, "");
		allProducts.add(product1);
		allProducts.add(product2);
		allProducts.add(product3);
	}

	@Override
	public ProductPojo addProduct(ProductPojo productPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductPojo> getAllProducts() {
		return allProducts;
	}

	@Override
	public ProductPojo getAProduct(int productId) {
		ProductPojo foundProduct = null;
		for(int i=0;i<allProducts.size();i++) {
			if(allProducts.get(i).getProductId() == productId) {
				foundProduct = allProducts.get(i); // when match found , assign the found reference variable to foundProduct
				break;
			}
		}
		return foundProduct;
	}

}
