import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import dao.ProductDao;
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
	    private ProductService service = new ProductServiceImpl();

		// JUnit 5 test method without mockito
		@Test
		public void testGetAProduct() {
			ProductService productService = new ProductServiceImpl();

			ProductPojo expectedPojo = new ProductPojo(1, "Apples", "Juicy Apples!", 15, "");
			ProductPojo actualPojo = null;
			try {
				// since there is no mockito, in the next line the service layer will call the
				// dao layer and that does not
				// qualify for unit testing
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
//		@Test
//		public void testAddProductWithMockito() {
//			
//			ProductPojo sendPojo = new ProductPojo(0, "Jackfruit", "Delecious Jackfruit!", 13, "");
//			ProductPojo returnPojo = new ProductPojo(5, "Jackfruit", "Delecious Jackfruit!", 13, "");
//			try {
//				when(daoMock.addProduct(sendPojo)).thenReturn(returnPojo);
//			} catch (SystemException e1) {
//				e1.printStackTrace();
//			}
//			
//			ProductService productService = new ProductServiceImpl();
//			ProductPojo expectedPojo = new ProductPojo(5, "Jackfruit", "Delecious Jackfruit!", 13, "");
//			ProductPojo theActualReturnPojo = null;
//			try {
//				
//				theActualReturnPojo = productService.addProduct(sendPojo);
//			} catch (SystemException e) {
//				e.printStackTrace();
//			}
//			assertEquals(expectedPojo, theActualReturnPojo);
//		}
	
}
