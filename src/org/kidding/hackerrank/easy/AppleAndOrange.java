package org.kidding.hackerrank.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOrange {
	
	//s는 집 시작 부분, t는 집 끝 부분. 즉 s~t는 집.
	//apple은 집 왼쪽, orange는 집 오른쪽
	//apple은 a, orange는 b에 위치 
	//+ - d 거리만큼 떨어짐. 
	// ㅇㅋ 끝. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());	//apple
		int b = Integer.parseInt(st.nextToken());	//orange
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());	//apple
		int n = Integer.parseInt(st.nextToken());	//orange	
		
		st = new StringTokenizer(br.readLine());
		int[] apples = new int[m];
		//떨어진 사과
		for(int i=0; i<m; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
			System.out.print(apples[i] + " ");
		}

		st = new StringTokenizer(br.readLine());
		int[] oranges = new int[n];
		//떨어진 사과
		for(int i=0; i<n; i++) {
			oranges[i] = Integer.parseInt(st.nextToken());
			System.out.print(oranges[i] + " ");
		}
		
		int apple = 0;
		int orange = 0;
		
		for(int i=0; i<m; i++) {
			if(a+apples[i] >= s && a+apples[i] <= t) {
				apple++;
			}; 
		}
		
		for(int i=0; i<n; i++) {
			if(b+oranges[i] >= s && b+oranges[i] <= t) {
				orange++;
			}; 
		}
		
		System.out.println(apple);
		System.out.println(orange);
	}
}
