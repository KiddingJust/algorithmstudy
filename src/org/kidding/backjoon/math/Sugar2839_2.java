package org.kidding.backjoon.math;

import java.util.Scanner;

public class Sugar2839_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		
		while (n > 0) {
			if (n % 5 ==0) {
				answer = (n/5)+answer;
				break;
				
				//왜 이거보다 느리지
				//n = n-5;
				//answer++;
			}else {
				n = n - 3;
				answer++;
			}
			
			if (n < 0) {
				answer = -1;
			}
		}
		
		System.out.println(answer);
		
	}

}
