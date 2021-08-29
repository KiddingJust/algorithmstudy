package org.kidding.programmers.leveltest;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/1835
public class L2_TogetherPicture {

	//개어려운데...?
	//1. 브루트포스 - 모두 서는 경우를 구하되 validation check!
	//2. 전체 경우의 수를 먼저 구하고(이건 고정값임)
	//   다시 
	
	static final String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static String[] data = {"N~F=0", "R~T>2"};
	static int cnt = 0;
	
	public static void main(String[] args) {
		boolean[] visited = new boolean[8];
		List<String> list = new ArrayList<>();
		
		dfs("", list, visited);
	
		System.out.println(cnt);
	}
	
	static void dfs(String line, List<String> list, boolean[] visited) {
		
		//size 8되면 validation check
		if(line.length() == 8) {
//			System.out.println(line);
			if(validationCheck(line, data)) {
//				System.out.println("true!");
				cnt++;
			}
			return;
		}
		
		//순서 바꾸는 정렬을 못하겠음.. 체크 필요. 
		for(int i=0; i<members.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				String nextLine = line+members[i];	//list로 그냥 추가해버리면 X
				dfs(nextLine, list, visited);
				visited[i] = false;
			}
		}
		
	}
	
	static boolean validationCheck(String line, String[] datas) {
		 
		for(String data:datas) {
			int pos1 = line.indexOf(data.charAt(0));
			int pos2 = line.indexOf(data.charAt(2));
			
//			System.out.println("pos1: " + pos1 + ", pos2: " + pos2);
//			System.out.println("data: " + data);
			
			char cal = data.charAt(3);
			int expected = data.charAt(4)-'0';
			
			if(cal == '=') {
				if(Math.abs(pos1-pos2)-1 != expected) {
					return false;
				}
			}else if(cal == '<') {
				if(Math.abs(pos1-pos2)-1 >= expected) {
					return false;
				}
			}else {
				if(Math.abs(pos1-pos2)-1 <= expected) {
					return false;
				}
			}
			
		}
		
		return true;
	}
}
