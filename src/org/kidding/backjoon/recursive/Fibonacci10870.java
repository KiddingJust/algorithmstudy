package org.kidding.backjoon.recursive;

import java.util.Scanner;

public class Fibonacci10870 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		int answer = fibo(10);
		System.out.println(answer);
		
		
	}
	
	static int fibo(int a) {
		System.out.println("a: " + a);
		if(a == 0) {
			return 0;
		}else if(a == 1) {
			return 1;
		}else {
			return fibo(a-1) + fibo(a-2);
		}
		
	}
	//f(4) = f(3) + f(2)
	// = f(2) + f(1) + f(1) + f(0)
	// = f(1) + 2 = 3
}
