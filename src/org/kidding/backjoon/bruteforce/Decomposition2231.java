package org.kidding.backjoon.bruteforce;

import java.util.Scanner;

public class Decomposition2231 {
	
	//216 => 198   (198 + 1 + 9 + 8)
	//256 => 245   (245 + 2 + 4 + 5)
	public static void main(String[] args) {
		//수 입력받기 
		
		//하나하나 자르기
		
		//loop문 돌리되,
		//가장 앞자릿수 + 9 + 9 부터 돌리기.  
		//218의 경우 199가 됨. 가장 먼저 나오는 값이 생성자. 
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = n;
		int decomp = 0;
		int start = 0;
		
		int first = 0;
		int pow = 0;
		while(true) {
			//t: 216 -> first: 21, t: 21, pow: 1
			//t: 21 -> first: 2, t: 2, pow: 2
			if(temp/10 > 0) {
				first = temp/10;
				temp /= 10;
				pow++;
			}else {
				break;
			}
		}
		start = (int) (first*Math.pow(10, pow)- 3*Math.pow(10, pow-1));
		System.out.println("start: " + start);
		
		for(int i=start; i<n; i++) {
			decomp = i;
			int num = i;
			System.out.println("i: " + i);
			while(num>0) {
				System.out.println("num: " + num);
				decomp += num%10;
				System.out.println("decomp: " + decomp);
				num = num/10;
				System.out.println("after num: " + num);
			}
			if(decomp == n) {
				System.out.println(i);
				return;
			}
		}	
		System.out.println("0");
	}
}

