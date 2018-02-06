package thong;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCollection {
	
	public static final void main(String[] args) {
		// Collections
		String s = "This is just a test for sorting";		
		List<String> list = Arrays.asList(s.split(" "));
		System.out.println(list);
		
		String[] words = {"Thong", "a", "test", "is"};
		for (String s2 : words) {
			System.out.println("binarySearch(" + s2 + ") = " + Collections.binarySearch(list, s2));
		}

		Double d;
		
		Collections.reverse(list);
		System.out.println("reverse()" + list);
		
		Collections.sort(list);
		System.out.println("sort(list): " + list);
		System.out.println("max(list): " + Collections.max(list));
		System.out.println("min(list): " + Collections.min(list));

		for (String s2 : words) {
			System.out.println("binarySearch(" + s2 + ") = " + Collections.binarySearch(list, s2));
		}
					
		// HashMap
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Hello", 1);
		map.put("There", 12);
		System.out.println(map.entrySet());
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.containsKey("Hello"));
		System.out.println(map.containsValue(13));
		System.out.println(map.containsValue(12));

	}

}
