package reflectiondemo;
import static org.junit.Assert.fail;

public class Room implements Comparable<Room>{
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + height;
		result = prime * result + length;
		result = prime * result + roomNo;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (roomNo != other.roomNo)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public int compareTo(Room o) {
		// returns -ve, 0 , +ve
		int floorArea1 = this.length * this.width;
		int floorArea2 = o.length * o.width;
		return floorArea1 - floorArea2;
		}

	@Override
	public String toString() {
		return "Room [length=" + length + ", width=" + width + ", height=" + height + ", color=" + color + ", roomNo="
				+ roomNo + "]";
	}
}
