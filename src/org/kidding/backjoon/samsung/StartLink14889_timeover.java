package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StartLink14889_timeover {
	
	public static ArrayList<Integer> answer = new ArrayList<Integer>();
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		visited = new boolean[n];
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = n/2;
		dfs(arr, 0, 0, n, r);
		Collections.sort(answer);
		System.out.println(answer.get(0));
		
	}
	
	
	static void dfs(int[][] arr, int start, int depth, int n, int r) {
		if(depth == r) {
			getDiffer(arr, n);

			return;
		}
				
		for(int i=start; i<n; i++) {
			
			//1이 포함되지 않은 Start팀은 이전에 Link팀으로 이미 한번 나옴. 
			if(depth == 0 && i == 2) {
				return;
			}
				visited[i] = true;
				start++;
				depth++;
				dfs(arr, start, depth, n, r);
				start--;
				depth--;
				visited[i] =false;
		}
	}
	
	
	static void getDiffer(int[][] arr, int n) {
		
		int sumS = 0;
		int sumL = 0;
		
		for(int i=0; i<n; i++) {
			if(visited[i] == true) {
				for(int j=0; j<n; j++) {
					if(visited[j] == true) {
						sumS += arr[i][j];
					}
				}
			}else {
				for(int j=0; j<n; j++) {
					if(visited[j] == false) {
						sumL += arr[i][j];
					}
				}
			}
		}
		answer.add(Math.abs(sumS-sumL));
	}
}
