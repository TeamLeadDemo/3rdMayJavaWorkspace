
public class Snake extends Animal{

	@Override
	boolean mobile() {
		System.out.println("snake crawls");
		return true;
	}
	
	boolean kills() {
		System.out.println("snake kills");
		return true;
	}

	
}
