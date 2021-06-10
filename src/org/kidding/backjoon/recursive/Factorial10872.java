package org.kidding.backjoon.recursive;

import java.util.Scanner;

public class Factorial10872 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(recursive(n));
		
	}
	
	static int recursive(int a) {
		if(a <= 1) {
			return 1;
		}else {
			return a*recursive(a-1);
		}
		
	}
}
