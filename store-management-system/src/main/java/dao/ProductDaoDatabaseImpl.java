package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import exception.EmptyStoreException;
import model.ProductPojo;

public class ProductDaoDatabaseImpl implements ProductDao{

	@Override
	public ProductPojo addProduct(ProductPojo productPojo) {
		
		// yet to work on exception handling flow
		// yet to work of getting back the auto generated primary key from the DB to java
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('"+productPojo.getProductName()+"', '"+productPojo.getProductDescription()+"', "+productPojo.getProductCost()+", '')";
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productPojo;
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
	public List<ProductPojo> getAllProducts() throws EmptyStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPojo getAProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
