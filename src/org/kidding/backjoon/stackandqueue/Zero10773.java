package org.kidding.backjoon.stackandqueue;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Zero10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Stack stack = new Stack();
		Stack<Integer> stack = new Stack<>();

		int n = sc.nextInt();
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			int input = sc.nextInt();
			if(input == 0) {
				stack.pop();
				continue;
			}
			stack.push(input);
		}
		
		Iterator<Integer> it = stack.iterator();
		while(it.hasNext()) {
			sum += (int)it.next();
		}
		
		System.out.println(sum);
	}
}
