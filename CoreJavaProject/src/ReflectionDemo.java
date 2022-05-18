import java.lang.reflect.Field;

public class ReflectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class roomClass = Room.class;
		Field[] allFields = roomClass.getDeclaredFields();
		for(Field eachField: allFields) {
			System.out.println(eachField.getName());
		}
	}

}
