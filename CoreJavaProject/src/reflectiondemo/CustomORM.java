package reflectiondemo;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomORM {

	public static void save(Employee emp) {

		// things that i need in order to frame the insert query
				// table name
				// column names
				// values

		String tableName = null;
		// collection to hold the column names
		List<String> allColumns = new ArrayList<String>();
		int value1 = 0;
		String value2 = null;

		// step 1
		Class empClass = emp.getClass();

		// code to take out the field values and the column names from the MyColumn annotation
		Field[] allEmpFields = empClass.getDeclaredFields();
		for (Field eachField : allEmpFields) {
			eachField.setAccessible(true);
			System.out.println(eachField.getName());
			// if the field is annotated with MyColumn annotation
			if (eachField.getAnnotation(MyColumn.class) != null) {

				try {
					// print the value of the field - not required
					System.out.println(eachField.get(emp));
					// print the annotation
					System.out.println(eachField.getAnnotation(MyColumn.class).name());
					allColumns.add(eachField.getAnnotation(MyColumn.class).name());
					if (eachField.get(emp) instanceof Integer) {
						value1 = (int) eachField.get(emp);
					} else if (eachField.get(emp) instanceof String) {
						value2 = (String) eachField.get(emp);
					}

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

		// to take out the table name from the MyTable annotation

		System.out.println(((MyTable) empClass.getAnnotation(MyTable.class)).name());
		tableName = ((MyTable) empClass.getAnnotation(MyTable.class)).name();
		
		// framing the insert query based on the data extracted from the Employee object using reflection
		String query = "INSERT INTO " + tableName + "(" + allColumns.get(0) + "," + allColumns.get(1) + ") VALUES ("
				+ value1 + ",'" + value2 + "')";

		//printing query on the console to check if it is framed properly - not required
		System.out.println("the query is:" + query);

		// now the query is in place
		// lets write jdbc code to insert in to table

		// step 1
		// step2
		// step 3
		// step 4
	}
}
