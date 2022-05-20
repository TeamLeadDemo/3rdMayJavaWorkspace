package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.EmptyStoreException;
import exception.ProductNotFoundException;
import exception.SystemException;
import model.ProductPojo;

public class ProductDaoDatabaseImpl implements ProductDao{

	private static final Logger LOG = LogManager.getLogger(ProductDaoDatabaseImpl.class);
	@Override
	public ProductPojo addProduct(ProductPojo productPojo)throws SystemException {
		LOG.info("Entered addProduct() in Dao...");
		// yet to work on exception handling flow - completed
		// yet to work of getting back the auto generated primary key from the DB to java - completed
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// next two lines commented to implement returning of primary key
//			String query = "INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('"+productPojo.getProductName()+"', '"+productPojo.getProductDescription()+"', "+productPojo.getProductCost()+", '')";
//			int rowsAffected = stmt.executeUpdate(query);
			
			// to get record that was inserted with the auto generated primary key
			String query = "INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('"+productPojo.getProductName()+"', '"+productPojo.getProductDescription()+"', "+productPojo.getProductCost()+", '') returning product_id";
			// using executeQuery instead of executeUpdate as the INSERT query here returns a coulumn data
			ResultSet resultSet = stmt.executeQuery(query);
			// moving the pointer from before first to first position in the result set
			resultSet.next();
			// assign the retrieved product id in the pojo
			productPojo.setProductId(resultSet.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		LOG.info("Exited addProduct() in Dao...");
		return productPojo;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// next two lines commented to implement returning of primary key
			String query = "UPDATE product_details SET product_cost="+productPojo.getProductCost()+"WHERE product_id="+productPojo.getProductId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return productPojo;
	}

	@Override
	public void deleteProduct(int productId) throws SystemException {
		LOG.info("Entered deleteProduct() in Dao...");
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// next two lines commented to implement returning of primary key
			String query = "DELETE FROM product_details WHERE product_id="+productId;
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		LOG.info("Exited deleteProduct() in Dao...");
	}

	@Override
	public List<ProductPojo> getAllProducts() throws EmptyStoreException, SystemException{
		LOG.info("Entered getAllProduct() in Dao...");
		// collection to hold all the records as pojos 
		
		List<ProductPojo> allProducts = new ArrayList<ProductPojo>();
		Connection conn = null;
		try {
			// obtain a connection to the db
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM product_details";
			//the resultSet hold the bunch of records returned by the select query
			ResultSet resultSet = stmt.executeQuery(query);
			int counter = 0;
			// traverse/iterate through the result set
			while(resultSet.next()) {
				counter++;
				// create a product pojo object and copy the first record's data into it
				ProductPojo productPojo = new ProductPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5));
				// add the product pojo object to the collection
				allProducts.add(productPojo);
			}
			if(counter == 0) {
				throw new EmptyStoreException();
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited getAllProduct() in Dao...");
		return allProducts;
		
	}

	@Override
	public ProductPojo getAProduct(int productId) throws SystemException {
		LOG.info("Entered getAProduct() in Dao...");
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
		LOG.info("Exited getAProduct() in Dao...");
		return productPojo;
	}

}
