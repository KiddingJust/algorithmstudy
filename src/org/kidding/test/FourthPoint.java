package org.kidding.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FourthPoint {
	public static void main(String[] args) {
		
		// 3개 입력받았을 때 2개가 아닌 1개짜
		// 
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3  =sc.nextInt();
		
		int[] arrX = {x1, x2, x3};
		int[] arrY = {y1, y2, y3};
		
		Arrays.sort(arrX);
		Arrays.sort(arrY);

		int answerX = arrX[0];
		int answerY = arrY[0];
		int countX = 0;
		int countY = 0;
		
		for (int i=0; i<arrX.length; i++) {
			if(answerX == arrX[i]) {
				countX++;
			}else {
				continue;
			}
		}
		
		for (int i=0; i<arrY.length; i++) {
			if(answerY == arrY[i]) {
				countY++;
			}else {
				continue;
			}
		}
		
		answerX = (countX == 1) ? arrX[0] : arrX[2];
		answerY = (countY == 1) ? arrY[0] : arrY[2];

		System.out.println(answerX + " " +answerY );
	}
}
