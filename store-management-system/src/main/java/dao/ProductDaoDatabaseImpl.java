package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.EmptyStoreException;
import exception.ProductNotFoundException;
import exception.SystemException;
import model.ProductPojo;

public class ProductDaoDatabaseImpl implements ProductDao{

	@Override
	public ProductPojo addProduct(ProductPojo productPojo)throws SystemException {
		
		// yet to work on exception handling flow - completed
		// yet to work of getting back the auto generated primary key from the DB to java
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('"+productPojo.getProductName()+"', '"+productPojo.getProductDescription()+"', "+productPojo.getProductCost()+", '')";
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new SystemException();
		}
		return productPojo;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int productId) throws SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductPojo> getAllProducts() throws EmptyStoreException, SystemException{
		List<ProductPojo> allProducts = new ArrayList<ProductPojo>();
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM product_details";
			ResultSet resultSet = stmt.executeQuery(query);
			int counter = 0;
			while(resultSet.next()) {
				counter++;
				ProductPojo productPojo = new ProductPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
				allProducts.add(productPojo);
			}
			if(counter == 0) {
				throw new EmptyStoreException();
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		return allProducts;
		
	}

	@Override
	public ProductPojo getAProduct(int productId) throws SystemException {
		Connection conn = null;
		ProductPojo productPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM product_details WHERE product_id="+productId;
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
				 productPojo = new ProductPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return productPojo;
	}

}
