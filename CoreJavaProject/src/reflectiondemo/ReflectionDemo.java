package reflectiondemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

	public static void main(String[] args) {
		
		// 1st step - obtain the Class obj of what you are trying to introspect
		
		// 3 ways
		// 1 - obtaining through the object
		String msg = "hello";
		Class msgClass = msg.getClass();
		
		// 2 - obtain through the class
		Class stringClass = String.class;
		
		// 3 - for anything other than classes, objects, enums etc
		Class intClass = int.class;
				
		// 2nd step - go ahead and introspect
		Constructor[] allStringCons = msgClass.getDeclaredConstructors();
		for(Constructor eachStringCons : allStringCons) {
			System.out.println("Name : " + eachStringCons.getName());
			Parameter[] eachConsAllParams = eachStringCons.getParameters();
			for(Parameter eachParam : eachConsAllParams) {
				System.out.println("Parameter name: " + eachParam.getName());
				System.out.println("Parameter type: " + eachParam.getType());
			}
			System.out.println("-----------------------");
		}
		
	}

}
