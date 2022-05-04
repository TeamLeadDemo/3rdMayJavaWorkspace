public class Room {
	// variables
	private int length;
	private int width;
	private int height;
	private String color;
	private int roomNo;

	Room(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	// lookout for constructor

	Room(int length, int width, int height, String color) {
		this(length, width, height);
//		this.length = length;
//		this.width = width;
//		this.height = height;
		this.color = color;
	}

	Room(int length, int width, int height, String color, int roomNo) {
		this(length, width, height, color); // constructor chaining
//		this.length = length;
//		this.width = width;
//		this.height = height;
//		this.color = color;
		this.roomNo = roomNo;
	}

	// public getters/setters, accessors/mutators, read/write
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	// methods
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
