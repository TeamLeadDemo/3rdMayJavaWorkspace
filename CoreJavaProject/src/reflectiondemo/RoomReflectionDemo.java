package reflectiondemo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class RoomReflectionDemo {

	public static void main(String[] args) {

		
		Room room1 = new Room(100,40,20);
		
		Class roomClass = room1.getClass();
		
		
		Field[] allRoomFields = roomClass.getDeclaredFields();
		for(Field eachRoomField : allRoomFields) {
			System.out.println("Name:" + eachRoomField.getName());
			System.out.println("Type:" + eachRoomField.getType());
			System.out.println("Modifier:" + Modifier.toString(eachRoomField.getModifiers()));
			System.out.println("--------------");
		}
		
	}

}
