package org.kidding.test;


// 이진 탐색의 탐색 시간은 'T = K * logN'으로 O(logN)이다
public class RecursiveFunction {

	
	public static void main(String[] args) {
		
		countdown(3);
	}
	
	
	public static void countdown(int i) {
		
		System.out.println(i); 
		
		if (i <= 1) {
			return;
		}else {
			i = i - 1;
			countdown(i);
		}
		
	}
}
