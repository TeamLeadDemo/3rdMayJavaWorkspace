
public class ExceptionDemo {

	public static void main(String[] args) {

		int a = 5;
		int b = 0;
		int c = 0;
		
		System.out.println("Going to divide");
		
		
		try {
			c = a/b;
			// 1. JVM identifies the type of exception
			// 2. creates an obj of the exception
			// 3. throws the obj
		}
		catch(ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("exception while dividing, fixing it");
			b = 1;
			c=a/b;
		}
		
		
		System.out.println(c);
		
		System.out.println("Division over");
		
	}

}
