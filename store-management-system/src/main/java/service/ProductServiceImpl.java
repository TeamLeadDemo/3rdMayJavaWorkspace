package service;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoCollectionImpl;
import dao.ProductDaoDatabaseImpl;
import exception.EmptyStoreException;
import exception.SystemException;
import model.ProductPojo;

public class ProductServiceImpl implements ProductService{

	ProductDao productDao;

	public ProductServiceImpl() {
		//productDao = new ProductDaoCollectionImpl();
		
		// changing the dao implementation
		productDao = new ProductDaoDatabaseImpl();
		
	}
	
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}



	@Override
	public ProductPojo addProduct(ProductPojo productPojo)throws SystemException  {
		return productDao.addProduct(productPojo);
	}

	@Override
	public ProductPojo updateProduct(ProductPojo productPojo)throws SystemException  {
		return productDao.updateProduct(productPojo);
	}

	@Override
	public void deleteProduct(int productId)throws SystemException {
		productDao.deleteProduct(productId);
	}

	@Override
	public List<ProductPojo> getAllProducts()throws EmptyStoreException, SystemException{
		return productDao.getAllProducts();
	}

	@Override
	public ProductPojo getAProduct(int productId)throws SystemException  {
		return productDao.getAProduct(productId);
	}
	
	

}
