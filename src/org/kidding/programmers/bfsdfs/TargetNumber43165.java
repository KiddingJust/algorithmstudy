package org.kidding.programmers.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TargetNumber43165 {

	private static int[] input;
	private static int len;
	private static int tarNum;
	private static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//임시로 길이 5 설정
		input = new int[5];

		len = input.length;
		
		for(int i=0; i<len; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		tarNum = Integer.parseInt(br.readLine());
		
		cal(0, 0);
		
		System.out.println(cnt);
	}
	
	static void cal(int idx, int val) {
//		System.out.println("cal(" + idx + ", " + val + ")");
		if(idx >= len) {
			if(val == tarNum) {
				cnt++;
			}
			return;
		}
		
		int newVal = val + input[idx];
		int newVal2 = val - input[idx];
		
		cal(idx+1, newVal);
		cal(idx+1, newVal2);
		
		return;
		
	}
	
	// 이렇게 안하고, val==tarNum일 떄 return 1, 아닐 떄 return 0 해서 count를 늘려줄 수 있음. 
	// 그리고 cal 메서드는 int 반환으로 해서 return cal1 + cal2 로 가능
	
}
