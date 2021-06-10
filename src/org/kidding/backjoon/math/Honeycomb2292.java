package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Honeycomb2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//1 
		//6 (2~7)
		//12 (8~19)
		//18   (20~37)
		//24   (38~61)
		
		//1 + 6(1) + 6(2) + 6(3) 
		//6 12 18 24 30 36 42 48 54
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i=1;
		int range = 1;
		
		if(n == 1) {
			System.out.println(n);
			return;
		}else {
			while(n > range) {
				range = range + 6*i;
				i++;
			}
			System.out.println(i);
		}
		
//		while(true) {
//			range = range + 6*i;
//			if(n <= range) {
//				System.out.println(i+1);
//				return;
//			}else {
//				i++;
//			}
//		}
//		System.out.println(n/6 + 2);
		
//		
//		Scanner in = new Scanner(System.in);
//		int N = in.nextInt();
//		int count = 1; // 겹 수(최소 루트)
//		int range = 2; // 범위 (최솟값 기준)
//		if (N == 1) {
//		System.out.print(1);
//		}
//		else {
//		while (range <= N) { // 범위가 N보다 커지기 직전까지 반복
//		range = range + (6 * count); // 다음 범위의 최솟값으로 초기화
//		count++; // count 1 증가
//		}
//		System.out.print(count);
//		}

	}
}
