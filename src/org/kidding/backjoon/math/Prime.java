package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println(a + " is Prime? >>>> " + isPrime(a));
		
	}
	
	public static boolean isPrime(int k) {
		if (k < 2) {
			return false;
		}
		for (int i=2; i*i<=k; i++) {	// 더 빠르게 구하려면 <=k/2 까지만 루프 돌려도 됨. 어차피 약수는 k/2보다는 작으므로
									// 가장 빠르게 구하는 방법은, 루트k보다 작거나 같은 자연수. i*i<=n. 
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
}
