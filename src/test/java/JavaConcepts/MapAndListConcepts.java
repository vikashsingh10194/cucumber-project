package JavaConcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapAndListConcepts {

	public static void main(String[] args) {

		////////////////////// hashmap ////////////////////

		Map<String, String> map = new HashMap<String, String>();
		map.put("integer1", "one");
		map.put(null, "two");
		map.put("integer2", "three");
		map.put("someString", "four");
		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>)iter.next();
			System.out.println(pair.getKey() + " and " +pair.getValue());             // result depend on key...
			
		}
		System.out.println("map is : " + map);
		
		////////////////////// arraylist////////////////////
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		
		Iterator<String> itera = list.iterator();
		while (itera.hasNext()) {
			System.out.println("list value : "+itera.next()); 			            // result in FIFO order...
			
		}
		
	}

}
