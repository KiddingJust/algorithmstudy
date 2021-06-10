package org.kidding.test;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int answer = 0;
				
		for(int i=input-1; i>0; i--) {
			System.out.println("input: " + input);

			int decomp = i;	//input: 245
			int div = i;
			while(div != 0) {
				System.out.println("div: " + div);
				decomp += div%10;	// 245 + 5 -> +4 -> +2
				div /= 10;			// 245 / 10 = 24 
				System.out.println("decomp: " + decomp);
			}

		}
        
		System.out.println(answer);
	}
}