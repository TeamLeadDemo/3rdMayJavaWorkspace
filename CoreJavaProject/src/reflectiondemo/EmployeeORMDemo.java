package reflectiondemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EmployeeORMDemo {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {


		// here we are trying to stimulate an ORM framework - say like a 3 to 5 %
		// the idea is to create an Employee Object(Entity) and 
				//inform the custom ORM(refer CustomORM class) framework to insert the data into the DB  
		Employee emp = new Employee(101, "ABC");
		
		// send this object to ORM framework which will in turn insert the data into employee_details table
		CustomORM.save(emp);
		
		// ORM - concept
		// JPA - Java Persistence API - specification
		// Hibernate - implementation of JPA specification
		
		
		
	}

}
