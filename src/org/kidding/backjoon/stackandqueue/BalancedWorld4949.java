package org.kidding.backjoon.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld4949 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		//이게 꼭 필요한 건 아님 
//		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		
		while(true) {
			String str = br.readLine();
			if(".".equals(str)) {
				break;
			}
			sb.append(solve(str)).append("\n");
		}

		System.out.println(sb);
	}
	
	static String solve(String str) {
		
		Stack<Character> stack = new Stack<>();
		//String 길이는 length로 가능.
		//charAt을 통해 자르기 가능. 
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(' || c == '[') {
				stack.push(c);
			}else if(c == ')') {
				//empty 먼저 써야함???
				if(stack.isEmpty() || stack.peek() != '(') {
					return "no";
				}else {
					stack.pop();
				}
			}else if(c == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					return "no";
				}else {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			return "yes";
		}else {
			return "no";
		}
	}
}

//		Stack<String> stack = new Stack<>();
//
//		while(true) {
//			System.out.println("몇번반복?");
//			int sumSmall = 0;	// ( ) 
//			int sumBig = 0;     // [ ] 
//			
//			while(st.hasMoreTokens()) {
//				stack.push(st.nextToken());
//			}
//			int cnt=stack.size();
//			while(cnt > 0) {
//				String temp = stack.pop();
//				switch(temp) {
//				case "(":
//					sumSmall--;
//					break;
//				case ")":
//					sumSmall++;
//					break;
//				case "[":
//					sumBig--;
//					break;
//				case "]":
//					sumBig++;
//					break;
//				}
//				cnt--;
//			}
//			
//			if(sumSmall != 0 || sumBig != 0) {
//				sb.append("no\n");
//			}else {
//				sb.append("yes\n");
//			}
//			
//			if(st.hasMoreElements() == false) {
//				System.out.println("언제 타는");
//				break;
//			}
//		}
//		
//		System.out.println(sb);
//		
//	}
