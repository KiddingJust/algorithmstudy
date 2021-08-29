package org.kidding.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1
public class MakeMillionare_NotGood {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		//가장 비싼 날을 찾고, 그 전날에는 가장비싼거-그날가격 해주기
		//그 인덱스를 저장해서, 다음 인덱스부터 다시 가장 비싼 날 찾고..반복.. ! 
		//인덱스가 가장 마지막이면 종료...! 
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] cost = br.readLine().split(" ");
			
			Long sum = 0L; 
			int maxIdx = -1;
			int PreMaxIdx = -1;
			
			//1. MAX 찾기 
			while(true) {
				int max = 0;
				PreMaxIdx = maxIdx;
				for(int j=maxIdx+1; j<cost.length; j++) {
					if(max < Integer.parseInt(cost[j])) {
						max = Integer.parseInt(cost[j]);
						maxIdx = j;
					}
				}
				System.out.println("max: " + max);
				System.out.println("maxIdx : " + maxIdx);
				
				for(int j=PreMaxIdx+1; j<maxIdx; j++) {
					sum += new Long(max-Integer.parseInt(cost[j]));
				}
				
				System.out.println("sum: " + sum);
				
				if(maxIdx == cost.length-1) {
					sb.append("#").append(i+" ").append(sum).append("\n");
					break;
				}
				
			}
		}//for i end
		
		System.out.println(sb);
	}
	
	
}
