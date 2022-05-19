package reflectiondemo;

@MyAnnotation
public class Sample {

	@MyAnnotation
	int number;
	
	@MyAnnotation
	String name;

	@MyAnnotation
	void display() {
		System.out.println(number);
		System.out.println(name);
	}
}
