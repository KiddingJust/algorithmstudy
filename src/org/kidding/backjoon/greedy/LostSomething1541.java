package org.kidding.backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostSomething1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\-");
		
		int sum=0;

		String[] firstSum = input[0].split("\\+");
		for(int i=0; i<firstSum.length; i++) {
			sum += Integer.parseInt(firstSum[i]);
		}
		
		if(input.length > 1) {
			for(int i=1; i<input.length; i++) {
				sum -= calc(input[i]);
			}			
		}
		
		System.out.println(sum);

	}
	
	static int calc(String str) {
		String[] arr = str.split("\\+");
		int minus = 0;
		
		for(int i=0; i<arr.length; i++) {
			minus += Integer.parseInt(arr[i]);
		}
		
		return minus;
	}
}
