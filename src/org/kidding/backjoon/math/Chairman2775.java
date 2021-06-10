package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chairman2775 {
	
	
	//k층 n호
	//(k-1)층 1~n호만큼의 사람 데려와 살아야함. 
	//0층부터 존재 
	
	
	/*
	1   5
	 1  4  10  20  35
	 1  3   6  10  15  ........
	 1  2   3   4   5  6  7  8  9  10
	 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// (1+2) + (1+(1+2)) 
		// (n, k) = (n-1, k) + (n, k-1)
		// 	arr[n][k] = arr[n-1][k] + arr[n][k-1];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		// 이렇게 할 수도 있지만,
		// n과 k의 범위가 정해져있고(생각보다 작음) + 반복 횟수가 정해지므로(반복 시마다 만드는 게 피곤할지도)
		// 그냥 미리 arr 배열을 완성해두고 답을 찾아가도 됨. 
		while(cnt>0) {
			//k층 n호 & 0층은 1씩 
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n+1][k+1];
			
			for(int i=0; i<k+1; i++) {
				arr[0][k] = 1;
			}
			//arr[n호][k층] j호 i층 
			for(int i=0; i<=k; i++) {
				for(int j=1; j<=n; j++) {
//					System.out.println("i: " + i + ", j: " + j);
					if(i==0) {
						arr[j][i] = j;
					}else if(j==1) {
						arr[j][i] = 1;
					}else {
						arr[j][i] = arr[j-1][i] + arr[j][i-1];
					}
//					System.out.println("arr[" + j +  "][" + i + "]="+arr[j][i]);
				}
			}
			System.out.println(arr[n][k]);
			cnt--;
		}
	}
	
}
