package org.kidding.backjoon.math;

import java.io.IOException;
import java.util.Scanner;

public class Rectangle3009 {
	
	// 매우 중요.
	// 단순히 반복문으로 찾을 생각하지 말고, 최대한 쉬운 방법을 찾아보기. 
	public static void main(String[] args) throws IOException {
		
    	Scanner sc = new Scanner(System.in);
        
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3  =sc.nextInt();
		
        int x[] = new int[1001];
        int y[] = new int[1001];

        x[x1]++;
        x[x2]++;
        x[x3]++;
        y[y1]++;
        y[y2]++;
        y[y3]++;
        
		int answerX = (x[x1] == 1) ? x1 : x2;
		int answerY = (y[y1] == 1) ? y1 : y2;
		
		
		answerX = (x[answerX] == 1) ? answerX : x3;
		answerY = (y[answerY] == 1) ? answerY : y3;
		
		System.out.println(answerX + " " +answerY );
	}
	
}
