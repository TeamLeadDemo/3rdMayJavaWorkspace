package multithreading;

class TaskA implements Runnable{
	
	int id = 0;
	
	public TaskA(int passId) {
		id = passId;
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