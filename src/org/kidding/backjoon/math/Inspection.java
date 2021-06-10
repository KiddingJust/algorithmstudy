package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


//스택오버플로
public class Inspection {
	
	static int temp;
	static int n;
	static int[] arr;
	// 2 -> 5, 9  output: 2, 4
	// 2 - > 5, 13 인 경우 output으로 8도 되나? 되겠지. 2, 4, 8
	// 1. 먼저 최소의 수를 구한다
	// 2. 그 수를 그 수보다 작은 수로 나누어주고 나머지를 구한다. 
	// 3. 나머지 수를 루프문을 돌면서 나머지가 같다면 pass해준다
	// 4. pass를 하다가 마지막 index도 같아지면 끗
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		
		recursive(arr[0], 2, n, 1, arr[1], sb);
		
		sb.substring(sb.length()-1, sb.length());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void recursive(int numerator, int denominator, int n, int j, int maxIndex, StringBuilder sb) {
		temp = numerator % denominator;

		if(denominator >= maxIndex) {
			return;
		};

		if(arr[j] % denominator == temp) {
			if(j == n-1) {
				sb.append(denominator + " ");
				j = 1;
				recursive(numerator, denominator+1, n, j, maxIndex, sb);
			}else {
				recursive(numerator, denominator, n, j+1, maxIndex, sb);
			}
		}else {
			j = 1;
			recursive(numerator, denominator+1, n, j, maxIndex, sb);
		}
	}
}
