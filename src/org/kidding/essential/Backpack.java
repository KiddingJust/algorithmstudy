package org.kidding.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backpack {
	
	//순서가 없는 Dynamic Programming / 무게 제한이 있음. 
	static int sum;
	static int value;
	static int max;
	static int[][] arr;
	static int start;
	
	public static void main(String[] args) throws IOException {
		
		//무게 W, 가치 V
		//무게의 합 <= K. 이 범위 안에서 최대치를 구하기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		arr = new int[n][2];
		
		//4 7
		//6 13
		//4 8
		//3 6
		//5 12 
		
		//DP[5][9] 
		//DP[10][17]
		
		
		
		
	}

}
