package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		
			
		//ExecutorService service = Executors.newFixedThreadPool(3);
		//ExecutorService service = Executors.newCachedThreadPool();
		//ExecutorService service = Executors.newScheduledThreadPool(5);
		ExecutorService service = Executors.newSingleThreadExecutor();
	
		
		for(int i=0;i<3;i++) {
			service.submit(new TaskA(i+1));	
		}
		service.shutdown();

	}

}
