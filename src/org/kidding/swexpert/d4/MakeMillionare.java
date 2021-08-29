package org.kidding.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1
public class MakeMillionare {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//가장 비싼 날을 찾고, 그 전날에는 가장비싼거-그날가격 해주기
		//그 인덱스를 저장해서, 다음 인덱스부터 다시 가장 비싼 날 찾고..반복.. ! 
		//인덱스가 가장 마지막이면 종료...! 
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int[] cost = new int[N];
			
			for(int j=0; j<N; j++) {
				cost[j] = sc.nextInt();
			}
			
			Long sum = 0L; 
			int max = N-1;
			for(int j=N-1; j>=0; j--) {
				if(cost[j] < cost[max]){
					sum += cost[max]-cost[j];
				}else{
					max = j;
				}
			}
			
			sb.append("#").append(i+" ").append(sum).append("\n");
			
		}//for i end
		
		System.out.println(sb);
	}
	
	
}
