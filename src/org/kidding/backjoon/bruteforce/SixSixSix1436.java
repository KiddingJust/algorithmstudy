package org.kidding.backjoon.bruteforce;

import java.util.Scanner;

public class SixSixSix1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = (int) ((n-1)*Math.pow(10, 3) + 666);
		System.out.println(answer);
	}
}
