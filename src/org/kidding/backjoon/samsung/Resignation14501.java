package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resignation14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//이런 문제의 경우 그.. Greedy 알고리즘 썼떤 것 같음. 
		//그냥 최대한으로 담아보는 거 
		//아 근데 그럴리 없는 게, 이건 가중치가 붙음. 
		//1일차에 5일 걸리는데 30 보상인 게 있다. 그런데 3일차에 2일 걸리는데 100 보상인 게 있음. 이러면 3일차 선택
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2]; 
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
		}
		
		int[] dp = new int[n+10];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			
			System.out.println("i =====>  " + i);
			//현재의 dp[i]는 과거에 구한 현재의 dp[i] 혹은 max 중 더 큰 값이 됨. 
			dp[i] = Math.max(max,dp[i]);
			System.out.println("dp[" + i + "]= " + dp[i]);
			System.out.println("max: " + max);
			int addTime = arr[i][0];
			int addPrice = arr[i][1];
			
			
			//현재 시점에서 미래의 dp를 구하는 방법 - 현재에서 일을 더 해주던가 아니면 그냥 그대로 두던가
			dp[i+addTime-1] = Math.max(dp[i+addTime-1], max+addPrice);
			System.out.println("dp[" + (i + addTime -1) + "] = " + (dp[i+addTime-1]));
			//dp[i]가 max보다 크다면 여기서 갱신해주기.  dp[i+addTime-1]이 dp[i]가 될수도 있음. 
			max = Math.max(max, dp[i]);
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(dp[i]);
		}
		
		
		
	}
}