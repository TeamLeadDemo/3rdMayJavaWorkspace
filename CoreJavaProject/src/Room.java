public class Room {
	// variables
	int length;
	int width;
	int height;
	String color;
	int roomNo;
	
	// lookout for constructor
	
	Room(int length, int width, int height){
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	Room(int length, int width, int height, String color){
		this(length, width, height);
//		this.length = length;
//		this.width = width;
//		this.height = height;
		this.color = color;
	}
	
	Room(int length, int width, int height, String color, int roomNo){
		this(length, width, height, color); // constructor chaining
//		this.length = length;
//		this.width = width;
//		this.height = height;
//		this.color = color;
		this.roomNo = roomNo;
	}
	
	//methods
	int calculateFloorArea() {
		int floorArea = length * width;
		return floorArea;
	}
	
	int calculatePaintingCost(int rate) {
		int wallArea = (2 * length * height) + (2 * width * height);
		int paintingCost = wallArea * rate; 
		return paintingCost;
	}
}