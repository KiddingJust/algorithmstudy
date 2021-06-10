package org.kidding.lowlevelpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Average {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] arrStr = br.readLine().split(" ");
			int num = Integer.parseInt(arrStr[0]);
			int[] arr = new int[num];
			int sum = 0;
			for(int j=1; j<arr.length+1; j++) {
				arr[j-1] = Integer.parseInt(arrStr[j]);
				sum += arr[j-1];
			}
			int avg = sum/num;
			int avgNum = 0;
			for(int score : arr) {
				if(score > avg) {
					avgNum++;
				}
			}
			System.out.printf("%.3f", (avgNum*100.0/num));
			System.out.println("%");
		}
		
		
	}
	
}
