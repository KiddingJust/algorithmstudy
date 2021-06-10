package org.kidding.programmers.hash;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_Disguise42578 {

	
	public static void main(String[] args) {
		
		//Combination
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		boolean[] visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<n+1; i++) {
			int[] output = new int[i];
			permutation(0, 0, i, arr, visited, output);
		}
	}
	
	static void permutation(int start, int depth, int num, int[] arr, boolean[] visited, int[] output) {
//		System.out.println("start: " + start + ", depth: " + depth);
		if(depth == num) {
			System.out.println(Arrays.toString(output));
			return;
		}
		for(int i=start; i<arr.length; i++) {
//			visited[i] = true;		//굳이 필요 없음.start가 다르기 때문. 
//			System.out.println("arr[i]: " + arr[i]);
			output[depth] = arr[i];
			permutation(i+1, depth+1, num, arr, visited, output);
		}
	}
}
