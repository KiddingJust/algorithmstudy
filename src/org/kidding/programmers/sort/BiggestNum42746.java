package org.kidding.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum42746 {

//	static int[] numbers = {6, 10, 2};
	static int[] numbers = {3, 30, 34, 5, 9};

	public static void main(String[] args) {
		
		String[] strNum = new String[numbers.length];

		//길이만큼 loop문 돌리면서 String으로 바꾸기
		//BFS든 DFS 써서 결합 시킨 후에 다시 int로 바꾸어주고 max값 저장하기
		for(int i=0; i<numbers.length; i++) {
			strNum[i] = String.valueOf(numbers[i]);
		}
		
		/*
		 6, 10 정렬할 때, 6+10 = 610, 10+6 = 106 이므로
		 610이 앞으로 와야함. 
	     고로 일반 정렬로는 안됨. 
		 */
		Arrays.sort(strNum, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return (str2+str1).compareTo(str1+str2);
			}
		});
//		for(int i=0; i<strNum.length; i++) {
//			System.out.println(strNum[i]);
//		}
		
		String answer = strNum[0].equals("0") ? strNum[0] : String.join("", strNum);
		
		System.out.println(answer);
		
	}
	
	
}
