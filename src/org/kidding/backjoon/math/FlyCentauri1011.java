package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlyCentauri1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		//1  = 1
		//2  = 1 1
		//3  = 1 1 1
		//4  = 1 2 1
		//5  = 1 2 1 1
		//6  = 1 2 2 1
		//7  = 1 2 2 1 1
		//8  = 1 2 3 1 1
		//9  = 1 2 3 2 1
		//10 = 1 2 3 2 1 1
		//11 = 1 2 3 2 2 1
		//12 = 1 2 3 3 2 1
		//13 = 1 2 3 3 2 1 1
		//14 = 1 2 3 3 2 2 1
		//15 = 1 2 3 3 3 2 1
		//16 = 1 2 3 4 3 2 1
		//1, 4, 9, 16, 25, 36, 49 
		// 95
		// 81 ~ 100
		// 81 17 18 19 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int n = y - x;
			
			int j = (int) Math.sqrt(n);
			if(n == j*j) {
//				System.out.println(j+j-1);
				answer[i] = j+j-1;
			}else if(n <= ((j*j)+(j+1)*(j+1))/2) {
//				System.out.println(j+j);
				answer[i] = j+j;
			}else {
//				System.out.println(j+j+1);
				answer[i] = j+j+1;
			}
			
//			int j = 0;	// 제곱수 구하
//			while(true) {
//				if(j*j >= n) {
//					break;
//				}
//				j++;
//			}
//			if(n <= ((j-1)*(j-1) + j*j)/2) {
//				System.out.println(j+(j-2));
//			}else {
//				System.out.println(j+(j-1));
//			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}
}
