package reflectiondemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EmployeeORMDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(101, "ABC");
		
		// send this object to ORM framework which will in turn insert the data into employee_details table
		
		// ORM - concept
		// JPA - Java Persistence API - specification
		// Hibernate - implementation of JPA specification
		
		
		// write jdbc code
		// things that i need to frame the insert query
			// table name
			// column names
			// values
		
		String tableName = null;
		String columnName1 = null;
		String columnName2 = null;
		int value1 = 0;
		String value2 = null;
		
		String query = "INSERT INTO " + tableName + "(" + columnName1 + "," + columnName2 +") VALUES (" + value1 + ",'" + value2 +"')" ;
		
		// step 1
		Class empClass = emp.getClass();
		
		Field[] allEmpFields = empClass.getDeclaredFields();
		for(Field eachField : allEmpFields) {
			eachField.setAccessible(true);
			System.out.println(eachField.getName());
			if(eachField.getAnnotation(MyColumn.class) != null) {
				try {
					System.out.println(eachField.get(emp));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("---------------");
		}
		
	}

}
