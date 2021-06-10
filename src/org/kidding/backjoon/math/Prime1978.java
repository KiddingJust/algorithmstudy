package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prime1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt=0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrime(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static boolean isPrime(int num) {
		
		if(num < 2) {
			return false;
		}
		
		for(int i=2; i*i<=num; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
