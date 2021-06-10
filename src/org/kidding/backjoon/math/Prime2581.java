package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime2581 {

	
	// M <= ? <= N 중 소수가 몇개인지 묻는 문제는 에라토노스의 체를 쓰면 
	// Eratoshenes2.java 를 참고 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int[] prime = new int[n];
		
		//1.에라토노스의 체를 통해 n이하 중 소수 구해주기 
		// 여기서 중요한 게 나오는데, count와 배열에 넣는 것을 같이 넣어줄 수 있음. 
		// 배열에 넣으면서, 0이 아닌 것을... 
		// 
		
		//2.m 이상인 경우를 제외하고 배열에 넣어주기
		
		
		//합과 갯수 구하기. 
		
	}
}
