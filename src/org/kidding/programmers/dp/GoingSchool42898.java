package org.kidding.programmers.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoingSchool42898 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] road = new int[m][n];	
		int[][] dp = new int[m][n];		

		int[][] puddles = {{2, 2}};
	
        for(int i=0; i<puddles.length; i++){
            int a = puddles[i][0]-1;
            int b = puddles[i][1]-1;
            System.out.println("road[" + a + "][" + b + "]");
            road[a][b] = 1;
            dp[a][b] = -1;
        }
        
//		for(int i=0; i<k; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			road[a][b] = 1;
//		}
		
		int answer = dfs(0, 0, m, n, road);
		
		System.out.println(answer);
		
		dp[0][0] = 1;
		//반복문으로 풀기
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.println("d[" + i + "][" + j + "]");
				if(i == 0 || j == 0) {
					dp[i][j] = 1;
					System.out.println(dp[i][j]);
					continue;
				}
				if(dp[i][j] == -1) {
					dp[i][j] = 0;
					System.out.println(dp[i][j]);
					continue;
				}
				
				if(i<m && j < n) {
					dp[i][j] += (dp[i-1][j]%1000000007 + dp[i][j-1]%1000000007);
					System.out.println(dp[i][j]);
				}

				

			}
		}
		System.out.println(dp[m-1][n-1]%1000000007);
	}
	
	static int dfs(int x, int y, int m, int n, int[][] road) {

		System.out.println("dfs(" + x + ", " + y + ")");
		if(x > m-1 || y > n-1) {
			System.out.println("out!");
			return 0;
		}
				
		if(x == m-1 && y == n-1) {
			System.out.println("1 더해지는 때 ");
			return 1;
		}

		if(road[x][y] == 1) {
			System.out.println("out!");
			return 0;
		}
		
        if(x == m-1 && y < n-1){
            return dfs(x, y+1, m, n, road);
        }
        
        if(x < m-1 && y == n-1){
            return dfs(x+1, y, m, n, road);
        }
		
		return dfs(x+1, y, m, n, road) + dfs(x, y+1, m, n, road);
	}
}
