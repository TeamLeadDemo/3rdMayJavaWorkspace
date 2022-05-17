import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FuntionalDemo {

	public static void main(String[] args) {

		// first way - conventional way
		Operation add = new Addition();
		int addResult = add.operate(5, 7);
		System.out.println("sum is:" + addResult);

		Operation product = new Multiply();
		int productResult = product.operate(5, 7);
		System.out.println("product is:" + productResult);

		// second way - anonymous classes
		// anonymous class do not have a name
		Operation add1 = new Operation() {
			// body of the anonymous class which implements Operation interface
			@Override
			public int operate(int num1, int num2) {
				return num1 + num2;
			}
		};
		int addResult1 = add1.operate(5, 7);
		System.out.println("sum(using anonymous classe implementation) is:" + addResult1);

		Operation product1 = new Operation() {

			@Override
			public int operate(int num1, int num2) {
				return num1 * num2;
			}
		};
		int productResult1 = product1.operate(5, 7);
		System.out.println("product(using anonymous classe implementation) is:" + productResult1);

		// third way - lambda expressions
		// lambda expressions work only for functional interfaces
		// paremeter's data types - not required
		// only one line of code - curly braces not required around the body
		Operation add2 = (num1, num2) -> num1 + num2;		
		int addResult2 = add2.operate(5, 7);
		System.out.println("sum(using lambda expressions) is:" + addResult2);

		Operation product2 = (num1, num2) -> num1 * num2;
		int productResult2 = product2.operate(5, 7);
		System.out.println("product(using lambda expression) is:" + productResult2);
		
		// fourth way - lambda expression used with inbuilt functional interfaces
		BiFunction<Integer, Integer, Integer> add3 = (num1 , num2) -> num1 + num2; 
		int addResult3 = add3.apply(5, 7);
		System.out.println("sum(using lambda expressions - inbuilt functional interface) is:" + addResult3);
	
		BiFunction<Integer, Integer, Integer> multiply3 = (num1 , num2) -> num1 * num2; 
		int productResult3 = multiply3.apply(5, 7);
		System.out.println("product(using lambda expressions - inbuilt functional interface) is:" + productResult3);
		
		/*
		 * 1) square of a number - Function
			2) generate a random number
			3) compute base and power, 3 and 2, 3 power 2, return 9
			4) if one number is greater than the other
			5) print a string in upper case
		 */
		//1
		Function<Integer, Integer> mySquare = (value) -> value * value;
		System.out.println(mySquare.apply(3));
		
		//2
		Supplier<Integer> myRandomGenerator = () -> (int)(Math.random() * 100);
		System.out.println("Random:" + myRandomGenerator.get());
		System.out.println(myRandomGenerator.get());
		
		//Supplier<Double> myRandomDecimalGenerator = () -> Math.random();
		Supplier<Double> myRandomDecimalGenerator = Math::random; // method reference
		// the signature of the method that you are refer to as the body of the lambda expression 
				//should be same as that of the abstract method of the functional interface
		System.out.println(myRandomDecimalGenerator.get());
		System.out.println(myRandomDecimalGenerator.get());
		
		//3
		BiFunction<Integer, Integer, Integer> compute = (base, power) -> {
			int ans = 1;
			if(power>0) {
				for(int i=1;i<=power;i++) {
					ans = ans * base;
				}	
			}
			return ans;
		};
		System.out.println(compute.apply(5, 2));
		
		//4
		BiPredicate<Integer, Integer> greaterLogic = (num1, num2) -> num1 > num2;
		System.out.println(greaterLogic.test(1, 3));
		
		//5
		//Consumer<String> myUpperCase = (msg) -> System.out.println(msg.toUpperCase());
		Consumer<String> myUpperCase = (msg) -> System.out.print(msg.toUpperCase());
		myUpperCase.accept("hello");
		
	}
}
