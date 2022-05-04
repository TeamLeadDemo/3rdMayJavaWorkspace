
public class StringDemo {

	public static void main(String[] args) {
		
		Room myRoom = new Room(300, 200, 100);
		
		//String myName = new String("hello"); // no need to use new keyword
		
		String str1 = "hello"; // recommended
		
		
		str1 = "welcome" + str1;
		str1 = "java" + str1;
		str1 = "abc" + str1;
		
		
		StringBuffer strBuffer = new StringBuffer("hello");
		strBuffer.append("welcome").append("java").append("abc");
		
		
		int[] mark = new int[5];

		String[] allNames = new String[10];
		
		Object[] obj = new Object[5];
		obj[0] = "hello";
		obj[1] = 12;
		obj[2] = 'd';
		obj[3] = true;
		obj[4] = 34.7;
		
		
		// Wrapper classes
		
		// byte    Byte
		// short   Short
		// int     Integer
		// long    Long
		// float   Float
		// double  Double
		// boolean Boolean
		// char	   Character
	
		//Integer i = new Integer(30); // better way to do this
		
		Integer i = 30; // this is possible because of autoboxing concept introduced in java 8
	}

}
