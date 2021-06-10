package org.kidding.backjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Bigger7568 {

	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][3];
		
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = 1;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) {
					continue;
				}
//				if(arr[i][0] < arr[j][0]) {
//					if(arr[i][1] < arr[j][1]) {
//						answer[i]++;
//					}
//				}
				//이게 더 단순. and조건으로 넣기. if를 계속 추가하지 말고. 
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					arr[i][2]++;
				}
			}
		}
		for(int i=0; i<n; i++)
		System.out.println(arr[i][2]);
	
	}
	
	
}
