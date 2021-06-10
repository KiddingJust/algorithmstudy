package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Snail2869 {

	// +A -B 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
//		int sumHeight = 0;
//		int days = 1;
		
//		while(true) {
//			sumHeight += A;
//			if(sumHeight >= V ) {
//				bw.write(days);
//				bw.flush();
//				return;
//			}else {
//				sumHeight -= B;
//				days++;
//			}
//		}		

		//시간초과로 인하여 위의 반복문 불가
		
		/*****************************************************
		반복문보다는 나눗셈을 통해 더 빠른 연산을 하자 
		*****************************************************/
		
//		System.out.println(Math.ceil((V-A)/(A-B)));
//		System.out.println(Math.ceil((double) 1/4));
		System.out.println((int) Math.ceil((double)(V-A)/(A-B))+1);
		//이렇게 올림해서 풀어도 되고 아니면 나누었을 때 나머지가 0이 아니라면 +1 해주면 됨. 
	}
	
}
