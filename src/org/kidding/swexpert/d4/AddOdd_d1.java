package org.kidding.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV5QSEhaA5sDFAUq&categoryId=AV5QSEhaA5sDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1
public class AddOdd_d1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T>0) {
			sb.append("#").append(T+" ");
			
			String[] nums = br.readLine().split(" ");
			int sum = 0;
			
			for(int i=0; i<10; i++) {
				int num = Integer.parseInt(nums[i]);
				if(num%2 == 0) {
					continue;
				}else {
					sum += num;
				}
			}
			
			sb.append(sum).append("\n");
			
			T--;
		}
		
		System.out.println(sb);
	}

}
