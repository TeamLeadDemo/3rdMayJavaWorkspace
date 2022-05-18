package multithreading;

public class SecondTechnique {

	public static void main(String[] args) {
		System.out.println("------- Main Thread started.... ---------");
		
		// 1
		// thread instatiation- here the thread not created at OS level
		FirstThread first = new FirstThread();
				
		FirstThread second = new FirstThread();
				
		System.out.println("------- Main thread ended..... ------------");
		
	}

}

// not recomnended to keep 2 classes in the same file, this is done only for the demo
class SecondThread extends Thread{
	static int count = 0;
	int id = 0;
	
	public SecondThread() {
		id = ++count;
		//3
		// starts the thread 
		// this is where the thread gets created at OS level.
		// the start() in turn calls the run()
		// at this point of time a child thread is spawned from the main thread
		start();
	}
	
	//2
	// task for the thread
	@Override
	public void run() {
		System.out.println("########## <"+id+"> started ##########");
		for(int i=1;i<5;i++) {
			System.out.println("<" + id + "> TICK TOCK : " + i );
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("########## <"+id+"> ends ##########");
	}
}