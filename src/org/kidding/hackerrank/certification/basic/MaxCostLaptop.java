package org.kidding.hackerrank.certification.basic;

import java.util.List;

public class MaxCostLaptop {

	//불량이면 카운트되지 않음. 
	//불량이어도 비용에는 포함됨
	//무조건 daily count 가 차야 비용에 포함됨. 
	
	static int[] cost = {3, 2, 3, 4, 5};
	static String[] labels = {"legal", "legal", "illegal", "legal", "legal"};
	static int dailyCount = 1; 
	
	public static void main(String[] args) {
		
		
		int dayCnt = dailyCount;
		int dayCost = 0;
		int max = 0;
		
		for(int i=0; i<cost.length; i++) {
			System.out.println("i: " + i);
			dayCost += cost[i];
			if(labels[i].equals("legal")) {
				dayCnt--;
				System.out.println("dailyCount: " + dayCnt);
			}
			
			System.out.println("dayCost: " + dayCost);
			if(dayCnt == 0) {
				if(dayCost>=max) {
					max = dayCost;
				}
				dayCost = 0;
				dayCnt = dailyCount;
			}
		}
		
		System.out.println("max: " + max);
	}
}
