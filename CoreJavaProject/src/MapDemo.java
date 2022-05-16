import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		
		phoneBook.put("ABC", 12347); // create
		phoneBook.put("XYZ", 33333);
		phoneBook.put("LMN", 55555);

		phoneBook.remove("LMN"); // Delete
		
		phoneBook.replace("XYZ", 88888); // update
		
		// read, traverse
		// take all the keys of the HashMap and put it inside a Set
		Set<String> allNames = phoneBook.keySet();
		// connect an iterator to this set
		Iterator<String> allNamesItrs = allNames.iterator();
		// traverse through the iterator
		while(allNamesItrs.hasNext()) {
			String key = allNamesItrs.next();
			Integer value = phoneBook.get(key);
			System.out.println(key + "\t" + value);
		}
		
		
		
		
	}

}
