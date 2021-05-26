package org.kidding.programmers.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TargetNumber43165 {
	
	private static int[] DP;
	private static int[] input;
	private static int tarNum;
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//�ӽ÷� ���� 5 ����
		input = new int[5];
		DP = new int[5];

		for(int i=0; i<input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		tarNum = Integer.parseInt(br.readLine());
		
		DP[0] = input[0];
		recur(4);
		
		System.out.println(" ------------------------- ");
		DP[0] = -input[0];
		recur(4);
		
		System.out.println(cnt);
	}
	
	static int recur(int n) {
		System.out.println("recur(" + n + ")");
		if(n == input.length) {
			return 0;
		}
		if(n == 0) {
			return DP[0];
		}
		if(DP[n] == 0) {
			DP[n] = recur(n-1) + input[n];
			DP[n] = 0;
			//DP[1] = 2�� ó���� �Ǵµ�, �� ������ �ٷ� DP[1] = 0 ���� ����ġ����
			//��� �̷��� ����ϸ� �ȵ� ��û�� 
			System.out.println("���� ");
			DP[n] = recur(n-1) - input[n];
			
		}
		
		if(DP[n] == tarNum) {
			cnt++;
		}

		System.out.println("DP[" + n + "] = " + DP[n]);
		return DP[n];
	}
}
