package org.kidding.backjoon.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Eratoshenes {
	
	//m이상 n이하 소수를 모두 출력하기
	//n 이하의 갯수를 모두 지워준 후에, m이상만 따로 구해주면 된다. 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		boolean check[] = new boolean[n+1];
		check[0] = check[1] = true;
		ArrayList<Integer> prime = new ArrayList<>();
		
		//만약 true면 다음 루프로, false면 배수 체크. 
		for(int i=2; i*i<=n; i++) {
			if(check[i] == true) {
				continue;
			}else {
				for(int j=i+i; j<=n; j+=i) {
					check[j] = true;
				}
			}
		}
		
		for(int i=m; i<=n; i++) {
			if(check[i] == false) {
				prime.add(i);
				System.out.println(i);
			}
		}
		
		System.out.println(prime.toString());
		
	}
}
