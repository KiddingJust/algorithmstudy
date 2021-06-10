package org.kidding.test;

import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] answerArr = new int[t];
		
		for(int i=0; i<t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			double d = y-x;		//행성 간 거리
			
			int n = (int) Math.ceil(Math.sqrt(d));
			int answer = 2*n - 1;
			if (d <= (Math.pow(n, 2)-n)) {
				answer = 2* (n-1);
			}
			answerArr[i] = answer;
		}//for end
		
		for(int i:answerArr) {
			System.out.println(i);
		}
	}
}
