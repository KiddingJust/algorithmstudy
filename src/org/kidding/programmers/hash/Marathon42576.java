package org.kidding.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Marathon42576 {

	static String[] participant = {"leo", "kiki", "eden", "mislav", "ana", "mislav"};
	static String[] completion = {"leo", "mislav", "kiki", "ana", "mislav"};
	
	public static void main(String[] args) {

		String answer = "";
		Map<String, Integer> hm = new HashMap<>();
		
		for(String name:participant) {
			hm.put(name, hm.getOrDefault(name, 0)+1);
		}
		
		for(String name:completion) {
			hm.put(name, hm.get(name) -1 );
		}
		
		for(String name:hm.keySet()) {
			if(hm.get(name) != 0) {
				answer = name;
			}
		}
		

		/*
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for(int i=0; i<participant.length-1; i++) {
			if(participant[i] != completion[i]) {
				answer = participant[i];
				break;
			}
		}
		*/
	}
}
