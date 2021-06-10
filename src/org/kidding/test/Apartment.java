package org.kidding.test;

import java.util.Arrays;
import java.util.Scanner;

public class Apartment {
	
	public static void main(String[] args) {
				
		//아파트 구조 
		//0~14층
		//1~14호 
		int[][] arr = new int[15][14];
		
		//초기화 
		for(int i=0; i < 15; i++) {
			//각 층의 1호에 거주하는 사람의 수
			arr[i][0] = 1;
		}
		
		//1층에 거주하는 사람의 수 
		for(int i=0; i<14; i++) {
			arr[0][i] = i + 1;
		}
		
		//i층의 j호에 사는 사람의 수는,
		//(i-1)층의 j호에 사는 사람 수 + i층의 j-1호에 사는 사람 
		for(int i=1; i<15; i++) {
			for(int j = 1; j<14; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		Scanner sc = new Scanner(System.in);

		//test 횟수 = t
		int t = sc.nextInt();
		//test 횟수에 따른 정답 출력 수
		int[] result = new int[t];
		//k층과 n호 입력받기. 배열 인덱스이므로 -1 
		for(int i=0; i<t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt()-1;
			result[i] = arr[k][n];
		}
		
		sc.close();
		
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
		
	}
	
}
