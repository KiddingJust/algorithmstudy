package org.kidding.javatest;

public class StaticClass {

	public static void main(String[] args) {
		
		int num = 1;
		
		int cnt = 0;
		int[][] test = new int[1][2];
		int[][] test2 = new int[1][2];

		test[0][0] = num;
		test[0][1] = cnt;
		test2[0][0] = num;
		test2[0][1] = cnt;
		System.out.println("num: " + test[0][0] + "cnt: " + test[0][1]);

		int answer1= dfs(test);
		System.out.println("===========================");
		System.out.println("num: " + test[0][0] + "cnt: " + test[0][1]);
		int answer2= dfs(test2);
	}
	
	static int dfs(int[][] test2) {
		System.out.println("dfs 호출");
		if(test2[0][1] == 5) {
			System.out.println("num: " + test2[0][0]);
			return -1;
		}
		
		test2[0][0] = test2[0][0] + 2;
		test2[0][1]++;
		dfs(test2);
		return 1;
	}
}
