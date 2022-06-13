import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Address;
import com.pojo.User;

public class CoreDemo {

	public static void main(String[] args) {
	
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Smith");
		
		Address address1 = new Address("Marietta", 30064);
		user1.setAddress(address1);
		
		System.out.println("user1 : " + user1);
		
		// lets create the spring core container
		ApplicationContext context = new ClassPathXmlApplicationContext("anyName.xml");
		
		User user2 = context.getBean("user", User.class);
		System.out.println("user2 : " + user2);
		
		User user3 = context.getBean("user", User.class);
		System.out.println("user3 : " + user3);
		user3.setFirstName("Harry");
		
		System.out.println("user2 : " + user2);
		System.out.println("user3 : " + user3);
	}

}
