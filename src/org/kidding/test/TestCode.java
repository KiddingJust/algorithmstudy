package org.kidding.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestCode {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30};
		
		int returnValue = solution(10, arr);
		System.out.println(returnValue);
	}
	
	

	public static int solution(int l, int[] v) {
   
		//12는 5+5+(5/5)+(5/5)
		//12는 55/5 + 5/5
		//12는 (55+5)/5
		//13은 5+5+(5/5)+(5/5)+(5/5)
		//13은 55/5 + 5/5 + 5/5
		//13은 (55+5+5)/5 
		// 18과 7은 7+7+(7/7)+(7/7)+(7/7)+(7/7)
		// (77+7+7+7+7+7+7+7)/7
		// 23과 6은? 6+6+6+6/6+6/6+6/6+6/6+6/6
		// 23과 6은? 66/6 + 66/6 + 6/6 + 6/6
		// 23과 6은? (66 + 66 + 6)/6 
		// 29와 8은? (88/8 + 88/8) + 8/8 + 8/8 + 8/8 + 
        // 123와 6은? 111 + 11 + 1 = (666+66+6)/6
		// 자연수가 주어질 때 111로 어떻게 나누는지 파악하기
		// 3826 은 1111+1111+1111+ 111 + 111 + 111 + 111 + 11+ 11+ 11+ 11+ 1+1+1+1+1
		//3826은 (6666+6666+6666+666+666+666+666+66+66+66+66+6+6+6+6+6)/6
		//특정 자연수가 주어질 때, 13과5를 보자 . 5*2 + 5/5 + 5/5 + 5/5 
        int answer = 0;

        return answer;
    }
}
