
public class Dog extends Animal{
	
	@Override
	boolean mobile() {
		System.out.println("dog walks");
		return true;
	}
	
	boolean friends() {
		System.out.println("dog is a friend");
		return true;
	}
}
