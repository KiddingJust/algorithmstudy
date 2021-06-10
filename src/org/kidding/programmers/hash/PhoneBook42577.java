package org.kidding.programmers.hash;

import java.util.HashMap;

public class PhoneBook42577 {

	
	static String[] phone_book = {"12","123","1235","567","88"};
	
	public static boolean main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<phone_book.length; i++) {
			map.put(phone_book[i], i);
		}
		
		for(String key: map.keySet()) {
			for(String key2: map.keySet()) {
				if(key == key2) {
					continue;
				}
				if(key.startsWith(key2) || key2.startsWith(key)) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
}
