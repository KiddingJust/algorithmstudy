package org.kidding.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;

public class Disguise42578 {

	static int cnt = 0;
	static HashMap<String, String> output;
	static String[][] arr = {{"yellowhat", "headgear"},
							{"bluesunglasses", "eyewear"},
							{"green_turban", "headgear"}};
	
	//순열로 하되 만약 value가 같은 게 있다면 하나 더 더해줘도 될듯
	//
	public static void main(String[] args) {
		
		int answer = 1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i][1], map.getOrDefault(arr[i][1], 0)+1);
			System.out.println("input result: "+map.get(arr[i][1]));;
		}
		
		for(String key : map.keySet()) {
			System.out.println("key: " + key);
			System.out.println("val: " + map.get(key));
			answer *= map.get(key)+1;
		}
		
		System.out.println(answer-1);
	}
	
}
