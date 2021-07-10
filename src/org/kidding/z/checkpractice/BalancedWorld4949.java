package org.kidding.z.checkpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String[] arr = br.readLine().split("");
			if(arr[0].equals(".")) {
				break;
			}
			Stack<String> stack = new Stack<>();
			for(int i=0; i<arr.length; i++) {
				String temp = arr[i];
//				System.out.println("temp: " + temp);
				if(temp.equals("(")) {
					stack.push("(");
				}else if(temp.equals("[")) {
					stack.push("[");
				}else if(temp.equals(")")) {
					if(!stack.isEmpty() && stack.peek().equals("(")) {
						stack.pop();
					}else {
						sb.append("no").append("\n");
						break;
					}
				}else if(temp.equals("]")) {
					if(!stack.isEmpty() && stack.peek().equals("[")) {
						stack.pop();
					}else {
						sb.append("no").append("\n");
						break;
					}
				}else if(temp.equals(".") && stack.isEmpty()) {
//					System.out.println("끝");
					sb.append("yes").append("\n");
				}else if(temp.equals(".") && !stack.isEmpty()) {
//					System.out.println("no 끝");
					sb.append("no").append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
