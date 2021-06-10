package org.kidding.backjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MakingOne1463 {

	private static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		
		System.out.println(recur(n));
		
	}
	
	static int recur(int n) {
//		System.out.println("recur(int " + n + ")");
		
		//그냥 6으로 나뉠 땐 3과 2와 -1 중 가장 작은 값
		//3으로 나뉠 때는 3과 -1 중 작은 값, 2로 나뉠 떈 2와 -1 중 작은 값
		//어느 것으로도 나뉘지 않을 땐 -1 
		
		//dp[n]==0 일 때만 계산해주는 이유는, dp[1]은 있는 값을 그대로 반환하기 위함. (루프도 멈추고)
		//n>1 은, dp[0], dp[1]도 0이기 때문에. 
		if(dp[n] == 0 && n>1) {	
			if(n%3 == 0) {
				dp[n] = recur(n/3) + 1;
			}else if(n%2 == 0) {
				if((n-1)%3 == 0) {
					dp[n] = Math.min(recur(n/2), recur(n-1))+1;

				}else {
					dp[n] = recur(n/2) +1;
				}
			}else{
				dp[n] = recur(n-1)+1;
			}
		}
		return dp[n];
	}
}
