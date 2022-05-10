package presentation;

import java.util.List;
import java.util.Scanner;

import exception.EmptyStoreException;
import model.ProductPojo;
import service.ProductService;
import service.ProductServiceImpl;

public class ProductManagementSystem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ProductService productService = new ProductServiceImpl();
		char proceed = 'y';
		
		while(proceed == 'y') {
			System.out.println("*****************************");
			System.out.println("PRODUCT MANAGEMENT SYSTEM");
			System.out.println("*****************************");
			System.out.println("1. List all Products");
			System.out.println("2. Add a new Product");
			System.out.println("3. Delete a Product");
			System.out.println("4. Update a Product");
			System.out.println("5. Exit");
			System.out.println("*****************************");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("*****************************");
			switch(option) {
				case 1:
					List<ProductPojo> everyProduct;
					try {
						everyProduct = productService.getAllProducts();
					} catch (EmptyStoreException e) {
						System.out.println(e.getMessage());
						break;
					}
					System.out.println("***************************************************************************************");
					System.out.println("ID\tNAME\tDESCRIPTION\t\t\tCOST");
					System.out.println("***************************************************************************************");
					everyProduct.forEach((item) -> System.out.println(item.getProductId() + "\t" + item.getProductName() + "\t" + item.getProductDescription() + "\t\t\t" + item.getProductCost()));
					System.out.println("***************************************************************************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
				case 2:
					ProductPojo newProductPojo = new ProductPojo();
					System.out.println("Please enter new Product Name : ");
					scan.nextLine();
					newProductPojo.setProductName(scan.nextLine());
					System.out.println("Please enter new Product Description : ");
					newProductPojo.setProductDescription(scan.nextLine());
					System.out.println("Please enter new Product Cost : ");
					newProductPojo.setProductCost(scan.nextInt());
					ProductPojo productPojo = productService.addProduct(newProductPojo);
					System.out.println("*****************************");
					System.out.println("New product added successfully! \nProduct ID is :" + productPojo.getProductId());
					System.out.println("*****************************");
					break;
				case 3:
					System.out.println("Please enter Product ID to be removed :");
					int productId = scan.nextInt(); 
					ProductPojo getProductPojo = productService.getAProduct(productId);
					if(getProductPojo == null) {
						System.out.println("*****************************");
						System.out.println("Product ID does not exist. \nPlease enter a valid Product ID!");
						System.out.println("*****************************");
						break;
					}else {
						System.out.println("*****************************");
						System.out.println("Product to be removed...");
						System.out.println("*****************************");
						System.out.println("Product ID : " + getProductPojo.getProductId());
						System.out.println("Product Name : " + getProductPojo.getProductName());
						System.out.println("Product Description : " + getProductPojo.getProductDescription());
						System.out.println("Product Cost : " + getProductPojo.getProductCost());
						System.out.println("*****************************");
						System.out.println("Are you sure you want to remove this product? (y/n) :");
						char answer = scan.next().charAt(0);
						System.out.println("*****************************");
						if(answer == 'y') {
							productService.deleteProduct(productId);
							System.out.println("Product removed from store...");
						}else {
							System.out.println("Product not removed from store...");
						}
						System.out.println("*****************************");
					}
					break;
				case 4:
					System.out.println("Please enter Product ID to be updated :");
					int updateProductId = scan.nextInt(); 
					ProductPojo updateProductPojo = productService.getAProduct(updateProductId);
					if(updateProductPojo == null) {
						System.out.println("*****************************");
						System.out.println("Product ID does not exist. \nPlease enter a valid Product ID!");
						System.out.println("*****************************");
						break;
					}else {
						System.out.println("*****************************");
						System.out.println("Product to be updated...");
						System.out.println("*****************************");
						System.out.println("Product ID : " + updateProductPojo.getProductId());
						System.out.println("Product Name : " + updateProductPojo.getProductName());
						System.out.println("Product Description : " + updateProductPojo.getProductDescription());
						System.out.println("Product Cost : " + updateProductPojo.getProductCost());
						System.out.println("*****************************");
						System.out.println("Please enter new Product Cost :");
						updateProductPojo.setProductCost(scan.nextInt());
						productService.updateProduct(updateProductPojo);
						System.out.println("*****************************");
						System.out.println("Product updated successfully...");
						System.out.println("*****************************");
					}
					break;
				case 5:
					System.out.println("*******************************************************************");
					System.out.println("Thank you for using Product Management System!!");
					System.out.println("*******************************************************************");
					System.exit(0);
				default:
					
			}
			
		}
		System.out.println("*******************************************************************");
		System.out.println("Thank you for using Product Management System!!");
		System.out.println("*******************************************************************");
		System.exit(0);
	}

}
