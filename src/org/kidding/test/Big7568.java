package org.kidding.test;

import java.util.Scanner;

public class Big7568 {
	
	//이중 for문으로 풀기. 더 쉬운 방법 없나 확인. 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] arr = new int[t][3];	//t 갯수만큼 몸무게, 키, 순위 담기
		
		for(int i=0; i<t; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = 1;
		}
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<t; j++) {
				if(arr[i][0]>arr[j][0] && arr[i][1]>arr[j][1]) {
					arr[j][2]++;
				}
			}
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(arr[i][2]);
		}
	}
}
