
public class RoomDemo {

	public static void main(String[] args) {
	
		int englishMark = 50;
		
		Room myRoom = new Room(400, 200, 100);
		//myRoom.length = 400;
		//myRoom.width = 200;
		//myRoom.height = 100;
		
		int recievedFloorArea = myRoom.calculateFloorArea();
		System.out.println("Floor Area is:" + recievedFloorArea);;
		
		int receivedCost = myRoom.calculatePaintingCost(1);
		System.out.println("painting cost:" + receivedCost);
		
		Room guestRoom = new Room(600, 400, 200, "cream", 101);
		
		
	}

}