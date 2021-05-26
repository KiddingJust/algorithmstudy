package org.kidding.backjoon.samsung;

import java.util.Scanner;

public class TestSupervisor13458 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int main = sc.nextInt();
		int sub = sc.nextInt();
		
		long answer = n;
		
		for(int i=0; i<n; i++) {
			if(arr[i] - main >= 0) {
				answer += Math.ceil((double)(arr[i]-main)/sub);
			}
		}
		
		System.out.println(answer);
		
	}
}
