package multithreading;

public class ThirdTechnique {

	public static void main(String[] args) {
		System.out.println("------- Main Thread started.... ---------");
		
		ThirdThread third = new ThirdThread();
		ThirdThread third1 = new ThirdThread();
		// 1
		// thread instatiation- here the thread not created at OS level
		Thread myThread = new Thread(third);
		// 3
		myThread.start();
	
		Thread myThread2 = new Thread(third1);
		myThread2.start();
		
		try {
			// to make sure that the child threads join the parent thread and then the parent thread ends
			myThread.join();
			myThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------- Main thread ended..... ------------");
		
	}

}

// not recomnended to keep 2 classes in the same file, this is done only for the demo
class ThirdThread implements Runnable{
	static int count = 0;
	int id = 0;
	
	public ThirdThread() {
		id = ++count;
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