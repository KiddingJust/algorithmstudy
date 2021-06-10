package org.kidding.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Disguise42578_AllCase {

	static int cnt = 0;
	static HashMap<String, String> output;
	static String[][] arr = {{"yellowhat", "headgear"},
							{"bluesunglasses", "eyewear"},
							{"green_turban", "headgear"}};
	
	//순열로 하되 만약 value가 같은 게 있다면 하나 더 더해줘도 될듯
	//
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i][0], arr[i][1]);
		}
		
		
		//일단 이게 아님. size는 key의 갯수에 따라 달라짐. 
		for(int i=2; i<3; i++) {
			output = new HashMap<String, String>();
			permutation(0, i, map);
		}
		
		System.out.println(cnt);
	}
	
	static void permutation(int depth, int num, HashMap<String,String> map) {
		System.out.println("depth: " + depth + ",  num: " + num);
		if(depth == num) {
			System.out.println("cnt++");
			cnt++;
			return;
		}
		for (Map.Entry<String, String> e1 : map.entrySet()) {
			System.out.println("getKey: " + e1.getKey() +", Value: "+ e1.getValue());

			if(output.containsKey(e1.getValue())) {
				System.out.println("여기 들어옴 ");
				continue;
			}
			output.put(e1.getValue(), e1.getKey());
			permutation(depth+1, num, map);
		}
	}
}
