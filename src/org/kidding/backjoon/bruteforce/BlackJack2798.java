package org.kidding.backjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack2798 {

	//1 반복문으로 풀어보기
	//2 재귀로는? 5 6 7 8 9  // https://zoonvivor.tistory.com/160 백트레킹 공부 후에! 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//바로 배열로 넣기? 아니면 StringTokenizer로...? 
		int[] arr = new int[n];
		//StringTokenizer를 다시 쓸 때는 이렇게. 줄이 바뀌면 다시 써야함. 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;	//m이 넘지 않는 최댓값
		
		for(int i=0; i<n-2; i++) {
			
			for(int j=i+1; j<n; j++) {
				
				for(int k=j+1; k<n; k++) {
					int temp = arr[i]+arr[j]+arr[k];
					System.out.println(arr[i]+" + "+arr[j]+" + "+arr[k] + " = " + temp);
					if(temp > m) {
						continue;
					}else {
						if(temp>=max) {
							max = temp;
						}
					}
				}
			}			
		}
		System.out.println(max);
		
		
	}   
	
	
	
}
