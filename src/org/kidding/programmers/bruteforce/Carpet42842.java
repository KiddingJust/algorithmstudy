package org.kidding.programmers.bruteforce;

import java.util.Scanner;

public class Carpet42842 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int b = sc.nextInt();
		int y = sc.nextInt();
		
		int row = 0;
		int col = 0;
		for(int i=1; i*i<=y; i++) {
			if(y%i == 0) {
				row = y/i; 		// i가 y의 약수이면, i * row = y
				if((row+2)*2 + i*2 == b) {
					row += 2;
					col = i+2;
					break;
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = row;
		answer[1] = col;
		System.out.println("row: " + row + "col: " + col);
		
	}
}




