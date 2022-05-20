import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import dao.ProductDao;
import dao.ProductDaoDatabaseImpl;
import exception.SystemException;
import model.ProductPojo;
import service.ProductService;
import service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	//@Mock will create a mock implementation for the ProductDao
		@Mock
	    private ProductDao daoMock;

		//@InjectMocks will inject the mocks marked with @Mock to this instance when it is created.
	    @InjectMocks
	    private ProductServiceImpl service;

		// JUnit 5 test method without mockito
		@Test
		public void testGetAProduct() {
			ProductService productService = new ProductServiceImpl();

			ProductPojo expectedPojo = new ProductPojo(1, "Apples", "Juicy Apples!", 15, "");
			ProductPojo actualPojo = null;
			try {
				// since there is no mockito, in the next line the service layer will call the
				// dao layer and that does not qualify for unit testing
				actualPojo = productService.getAProduct(1);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// for assert equals to work, ProductPojo class should have overridden equals
			// and hashcode method
			assertEquals(expectedPojo, actualPojo);
		}

		// JUnit 5 test method with mockito
		// to work with mockito and mockito related annotation, add the mockito core maven dependency in pom.xml - refer pom.xml
		// to work with mockito extension, add the mockito-junit-jupiter maven dependency in pom.xml - refer pom.xml
		// to fix noSuchMethod error, a Junit launcher dependency is added in pom.xml - refer pom.xml
		@Test
		
		public void testAddProductWithMockito() throws SystemException {
			
			ProductPojo sendPojo = new ProductPojo(0, "Jackfruit", "Delecious Jackfruit!", 13, "");
			ProductPojo returnPojo = new ProductPojo(5, "Jackfruit", "Delecious Jackfruit!", 13, "");
			
			//mockito rule to avoid the call to the dao method while testing service method
			//could try different ways to define the mockito rule
			when(daoMock.addProduct(sendPojo)).thenReturn(returnPojo);
				
			
			ProductPojo expectedPojo = new ProductPojo(5, "Jackfruit", "Delecious Jackfruit!", 13, "");
			ProductPojo theActualReturnPojo = null;
			try {	
				theActualReturnPojo = service.addProduct(sendPojo);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			assertEquals(expectedPojo, theActualReturnPojo);
		}
	
}
