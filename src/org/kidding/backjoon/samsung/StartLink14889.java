package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StartLink14889 {
	
	public static ArrayList<Integer> answer = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		boolean[] visited = new boolean[n];
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(arr, visited, 0, n, n/2);
        
		Collections.sort(answer);
		System.out.println(answer.get(0));
	}
	
	
	static void dfs(int[][] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			getDiffer(arr, visited, n);
			return;
		}
		
			for(int i=start; i<n; i++) {
				visited[i] = true;
				dfs(arr, visited, i+1, n, r-1 );
				visited[i] =false;			
			}
		
	}
	
	
	static void getDiffer(int[][] arr, boolean[] visited, int n) {
		
		int sumS = 0;
		int sumL = 0;
		
		//1,3,5 true, 2,4,6 false인 경우, 
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if (visited[i] == true && visited[j] == true) {
					sumS += arr[i][j];
					sumS += arr[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (visited[i] == false && visited[j] == false) {
					sumL += arr[i][j];
					sumL += arr[j][i];
				}			
			}
		}
		
//		for(int i=0; i<n; i++) {
//			if(visited[i] == true) {
//				for(int j=0; j<n; j++) {
//					if(visited[j] == true) {
//						sumS += arr[i][j];
//					}
//				}
//			}else {
//				for(int j=0; j<n; j++) {
//					if(visited[j] == false) {
//						sumL += arr[i][j];
//					}
//				}
//			}
//		}
		
		
		answer.add(Math.abs(sumS-sumL));
	}
}
