import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		// CRUD, features
		//PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>(); // bad practice - no abstraction and no polymorphism
		
		Queue<Integer> myQueue = new PriorityQueue<Integer>(); // good practice
		
		myQueue.add(5);
		myQueue.add(10);
		myQueue.add(15);
		//myQueue.add(null);
		
		//traversing the collection
		Iterator<Integer> itr = myQueue.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("-----------");
		myQueue.remove();
		
		Iterator<Integer> itr1 = myQueue.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		
		
	}

}
