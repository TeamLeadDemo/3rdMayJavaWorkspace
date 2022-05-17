import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// source - collection
		List<Integer> myNumbers = new ArrayList<Integer>();
		myNumbers.add(80);
		myNumbers.add(23);
		myNumbers.add(60);
		myNumbers.add(13);
		myNumbers.add(30);

		// connecting a stream to the source (collection)
		Stream<Integer> myStream = myNumbers.stream();
		
		// call the stream methods(operation)
		// 2 types - terminal operation(method)
		//         - intermediate operation(method)
		
		// can call any of intermediate method on the stream
		// but it should end with a terminal method
		
		// calling an intermediate function
		Stream<Integer> anotherStream = myStream.filter((value) -> value>50);
		
		// calling a terminal function
		long counterOfNumbers = anotherStream.count();
		
		System.out.println("Count of numbers greater than 50:" + counterOfNumbers);
		
		long count = myNumbers.stream().filter((value) -> value>50).count();
		
		System.out.println("Count of numbers greater than 50:" + count);
		
		Optional<Integer> dataInOptional = myNumbers.stream().reduce((sum, next) -> sum + next);
		if(dataInOptional.isPresent()) {
			System.out.println("Sum of the numbers in the collection:" + dataInOptional.get());
		}
		
		// EmployeePojo empPojo = employeeService.getEmployee(1234);
		// System.out.println(empPojo.getName()); // gives NullPOinterException if empojo is null

		// EmployeePojo empPojo = employeeService.getEmployee(1234);
		// Optional myData = Optional.of(empPojo);
		// if(myData.isPresent(){//then get }
		
		
		List<Integer> myFilteredNumbers = myNumbers.stream().filter((value) -> value<50).collect(Collectors.toList());
		myFilteredNumbers.forEach(data -> System.out.println(data));
		
		
	}

}
