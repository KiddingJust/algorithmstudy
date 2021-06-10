package org.kidding.test;

import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int[] arr = new int[number];
		
		for(int i=0; i<number; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = arr[0];
		int min = arr[0];
				
		for(int i:arr) {
			if(max < i) {
				max = i;
			}
			
			if(min > i) {
				min = i;
			}
		}
		
		System.out.println(min + " " + max);
	}
}
