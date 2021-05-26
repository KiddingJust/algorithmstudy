package org.kidding.hackerrank.easy;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/kangaroo/problem
public class NumberLineJumps {

	//캥거루가 점프해서 같은 위치에 존재할 수 있는지 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int v1 = sc.nextInt();
		int x2 = sc.nextInt();
		int v2 = sc.nextInt();
		
		// 10000 12 6948 17
		// 10000 + 12x = 6948 + 17x 
		// 5x = 3052 
		if(v2 >= v1) {
			System.out.println("NO");
		}
		//x2가 무조건 더 큼
		if((x2-x1)%(v1-v2) == 0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
	
}
