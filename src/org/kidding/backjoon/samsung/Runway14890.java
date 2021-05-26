package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runway14890 {

	static int L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
		int[][] arrX = new int[n][n];
		int[][] arrY = new int[n][n];
		boolean[] plate = new boolean[n];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arrX[i][j] = Integer.parseInt(st.nextToken());
				arrY[j][i] = arrX[i][j];
			}
		}
		
//		for(int i=0; i<n; i++) {
//			System.out.println();
//			for(int j=0; j<n; j++) {
//				System.out.print(arrX[i][j] + " ");
//			}
//		}
//		
//		System.out.println( );
//		
//		for(int i=0; i<n; i++) {
//			System.out.println();
//			for(int j=0; j<n; j++) {
//				System.out.print(arrY[i][j] + " ");
//			}
//		}
		
		// 행 먼저 탐색 
		for(int i=0; i<n; i++) {
//			System.out.println("i: " + i);
			plate = new boolean[n];
			Loop1 :
			for(int j=0; j<n-1; j++) {
				boolean flag = false;
				if(arrX[i][j+1] == arrX[i][j]) {
					flag = true;
				}else {
					if(Math.abs(arrX[i][j+1] - arrX[i][j]) > 1) {
						break Loop1;
					//다음 칸이 1 높다면 
					}else if(arrX[i][j+1] > arrX[i][j]) {
						//발판 놓을 공간은 필요.
						if(j+1-L >= 0) {
							for(int k=j; k>j-L; k--) {
								if(arrX[i][k] == arrX[i][j] && plate[k] == false) {
									plate[k] = true;
									flag = true;
								}else {
									break Loop1;
								}
							}			
						}else {
							break Loop1;
						}
						
					//다음 칸이 1 낮다면 
					}else {
						if(j+1+L <= n) {
							for(int k=j+1; k<j+L+1; k++) { 
								if(arrX[i][k] == arrX[i][j+1] && plate[k] == false) {
									plate[k] = true;
									flag = true;
								}else {
									break Loop1;
								}
							}		
						}else {
							break Loop1;
						}	
					}
				}// if ~ else 끝
				
				if(flag == true && j == n-2) {
//					System.out.println("추가");
					cnt++;
				}					
			}
		}// 행 for문 끝
		
		
		// 열 탐색 
		for(int i=0; i<n; i++) {
//			System.out.println("i: " + i);
			plate = new boolean[n];
			Loop1 :
			for(int j=0; j<n-1; j++) {
				boolean flag = false;
				if(arrY[i][j+1] == arrY[i][j]) {
					flag = true;
				}else {
					if(Math.abs(arrY[i][j+1] - arrY[i][j]) > 1) {
						break Loop1;
					//다음 칸이 1 높다면 
					}else if(arrY[i][j+1] > arrY[i][j]) {
						//발판 놓을 공간은 필요.
						if(j+1-L >= 0) {
							for(int k=j; k>j-L; k--) {
								if(arrY[i][k] == arrY[i][j] && plate[k] == false) {
									plate[k] = true;
									flag = true;
								}else {
									break Loop1;
								}
							}			
						}else {
							break Loop1;
						}
						
					//다음 칸이 1 낮다면 
					}else {
						//3 3 3 2 3 3 
						if(j+1+L <= n) {
							for(int k=j+1; k<j+L+1; k++) { 
								if(arrY[i][k] == arrY[i][j+1] && plate[k] == false) {
									plate[k] = true;
									flag = true;
								}else {
									break Loop1;
								}
							}		
						}else {
							break Loop1;
						}	
					}
				}// if ~ else 끝
				
				if(flag == true && j == n-2) {
//					System.out.println("추가");
					cnt++;
				}					
			}
		}// 열 for문 끝 
		
		System.out.println(cnt);
	}
	
}
