package org.kidding.programmers.leveltest;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

//같은 알파벳 2개 있는 짝 찾아서 제거하고 
//앞뒤 문자열 붙이기 
//반복해서 문자열 모두 제거하기 
//가능하면 1, 아니면 0 

// *******************8
// 굳이 dfs 해줄필요 없음. 그냥 stack으로 한번에 처리 가능. 
public class L2_matchAndRemove {

	static boolean returnValue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int answer = 0;
		//stack으로 구현해서 이전꺼랑 같으면 이전꺼 빼주고, 스킵
		//이전이랑 다르면 스택에 넣음. 
		//이걸 계속 반복. 스택이 비어있으면 1, 아니면 0. 
		
		dfs(s);
		if(returnValue) {
			answer = 1;
		};
		
		System.out.println(answer);
	}
	
	static void dfs(String s){
		
//		System.out.println("s: " + s);
		boolean flag = false;
		
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
//			System.out.println("char: " + s.charAt(i));
			if(stack.isEmpty()) {
				stack.push(s.charAt(i));
				continue;
			}
			int preNum = stack.peek();
			if(preNum == s.charAt(i)) {
				flag = true;
				stack.pop();
			}else {
				stack.push(s.charAt(i));
			}
		}
		
		if(stack.isEmpty()) {
			returnValue = true;
			return;
		}
		
		String remain = "";
		Iterator<Character> it = stack.iterator();
		while(it.hasNext()) {
			remain += it.next();
		}

		if(flag == true) {
			dfs(remain);
		}else {
			returnValue = false;
			return;
		}

	}
}
