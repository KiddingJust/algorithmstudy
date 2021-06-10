package org.kidding.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class NonDivisible {

	//정수로 이루어진 집합 S
	//최대 크기의 하위집합 S를 구해야하는데, 집합 안의 2개의 수를 더했을 때 k로 나누어지지 않아야 함. 
	//10은 22만 X. 12는 24만X. 19는 25만 X. 
	//10, 12, 19 / 10, 12, 25 / 19, 22, 24 등등. 최대 길이는 3. 
	//1, 7, 2, 4 의 경우는?  k = 3
	//1은 2 X. 7도 2 X. 4 는 2 X. 1, 4, 7. --> 3 
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 st = new StringTokenizer(br.readLine());
		 List<Integer> s = new ArrayList<>();
		 for(int i=0; i<n; i++) {
			 s.add(Integer.parseInt(st.nextToken()));
		 }
		 
		 //나머지 0~k-1 넣어야 하므로 k크기
		 int[] sRemain = new int[k];
		 for(int i=0; i<s.size(); i++) {
			  sRemain[s.get(i)%k]++;
		 }		 
//		 for(int i=0; i<sRemain.length; i++) {
//		  	 System.out.println(i + ": " + sRemain[i]);
//		 }
		 int answer = 0;
		 if(sRemain[0] != 0) {
			 answer ++;
		 }
		 for(int j=1; j<=k/2; j++) {
			 answer += Math.max(sRemain[j], sRemain[k-j]);
		 }
		 
		 
		 
		 
		 
		 
	

	}
}
