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
	
	//파라미터로 넘긴 것의 값도 변경된다!!! 음... int[][] test 값 변화. 
	//파라미터에 들어가는 변수 이름이 main methods에서 선언해준 변수 이름이어도 문제 X
	//main methods에서 호출 시 전달한 파라미터가 그대로 변수로 들어감. 
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
