package org.kidding.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/grading/problem
public class GradingStudent {

	// 40점 미만이면 과락. 37점까지는 과락이라 생각하면 된다. 
	// 36점 -> 다음 5의 배수인 40과의 차이가 3보다 큼. 그럼 
	// 3보다 차이가 작으면 올림해줌. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			
			int temp = sc.nextInt();
			int surplus =  temp%5;
			if(temp > 37 && surplus >= 3) {
				temp = temp + (5-surplus);					
			}
			sb.append(temp+"\n");
		}
		List<Integer> answer = new ArrayList<Integer>();
		System.out.println(sb);
	}
}
