package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class FashionKing {
	
	//한 종류는 2개씩 입을 수 없음. 
	//face: mask, sunglasses, makeup
	//각 종류별 경우의 수: n+1 (mask, sunglasses, makeup, 0)
	//제외: 1 (아무것도 X)
	//A: a, b, c
	//B: a, c
	//입력: a A, b B, c A, d A, e B
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {

			Map<String, Integer> kindCount = new HashMap<String, Integer>();
			int n = Integer.parseInt(br.readLine());
			for(int j=0; j<n; j++) {
				String[] input = br.readLine().split(" ");
				String inputKey = input[1];
				if(kindCount.containsKey(inputKey)) {
					kindCount.put(inputKey, kindCount.get(inputKey) + 1);
				}else {
					kindCount.put(inputKey, 2);
				}
			}//map생성 끝.
			
			int cnt = 1;
			for(int k:kindCount.values()) {
				cnt *= k;
			}
			
			sb.append(cnt-1 + "\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
}
