package org.kidding.backjoon.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBigNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			while(true) {
				if(stack.isEmpty()) {
					stack.push(i);
					break;
				}else if(arr[stack.peek()] >= arr[i]) {
					stack.push(i);
					break;
				}else if(arr[stack.peek()] < arr[i]) {
					arr[stack.pop()] = arr[i];
				}
			}
		}
		while(!stack.isEmpty()) {
//			System.out.println("peek i=" + stack.peek() + ", num=" + arr[stack.peek()]);
			arr[stack.pop()] = -1;
		}
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
		//이제 이걸 출력 형식 맞춰주기만 하면 됨. 
	}
}
