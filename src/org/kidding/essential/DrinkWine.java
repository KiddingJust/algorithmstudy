package org.kidding.essential;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class DrinkWine {
	
	//순서가 있는 Dynamic Programming 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 첫잔
        if (n >= 1) {
            dp[0] = arr[0];
        }
        // 두잔
        if (n >= 2) {
            dp[1] = arr[0] + arr[1];
        }
        // 세잔 
        if (n >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
        }
        //세잔 이상부터는 값 설정 후 동일한 점화식 
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }
        System.out.println(dp[n - 1]);
    }
}
