
public class MainThreadDemo {

	public static void main(String[] args) {

		System.out.println("Main thread running....");
		Thread mainThread = Thread.currentThread();
		
		//explore the properties of Thread
		System.out.println(mainThread.isAlive());
		System.out.println(mainThread.isDaemon());
		System.out.println(mainThread.getName());
		System.out.println(mainThread.getPriority());
		System.out.println(mainThread);

	}

}
