import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		Set<String> allNames = new HashSet<String>();
		
		allNames.add("abc");
		allNames.add("xyz");
		allNames.add("lmn");
		allNames.add("qqq");
		allNames.add("yyy");
		allNames.add("lmn");
		
		
		Iterator<String> itr = allNames.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("-------------");
		Set<Room> allRooms = new HashSet<Room>();
		allRooms.add(new Room(100, 100, 100));
		allRooms.add(new Room(300, 200, 100));
		allRooms.add(new Room(400, 150, 100));
		allRooms.add(new Room(100, 100, 100));
		
		Iterator<Room> itrRoom = allRooms.iterator();
		while(itrRoom.hasNext()) {
			System.out.println(itrRoom.next());
		}
		
		System.out.println("-----------");
		Set<Room> myRooms = new TreeSet<Room>();
		
		// TressSet expects the object added to implements Comparable interface
		myRooms.add(new Room(100, 100, 100));
		myRooms.add(new Room(300, 200, 100));
		myRooms.add(new Room(400, 150, 100));
		
		Iterator<Room> itrMyRoom = myRooms.iterator();
		while(itrMyRoom.hasNext()) {
			System.out.println(itrMyRoom.next());
		}
		
	}

}
