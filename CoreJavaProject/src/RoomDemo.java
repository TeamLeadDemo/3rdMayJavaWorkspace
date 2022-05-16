
public class RoomDemo {

	public static void main(String[] args) {
	
		Room room1 = new Room(100,  200, 300);
		room1.calculateFloorArea(); // doesnt give NullPointerException
		
		Room room2  = null;
		room2.calculateFloorArea(); // this gives NullPointerException
		
		int englishMark = 50;
		
		Room myRoom = new Room(400, 200, 100);
		//myRoom.length = 400;
		//myRoom.width = 200;
		//myRoom.height = 100;
		
		//myRoom.color = "blue";
		myRoom.setColor("blue");
		
		System.out.println(myRoom.getColor());
		
		int recievedFloorArea = myRoom.calculateFloorArea();
		System.out.println("Floor Area is:" + recievedFloorArea);;
		
		int receivedCost = myRoom.calculatePaintingCost(1);
		System.out.println("painting cost:" + receivedCost);
		
		Room guestRoom = new Room(600, 400, 200, "cream", 101);
		
		
	}

}
