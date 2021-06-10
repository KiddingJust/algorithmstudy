package org.kidding.backjoon.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MeetSchedule1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
		int n = sc.nextInt();
		int[][] meet = new int[n][2];
		for(int i=0; i<n; i++) {
			meet[i][0] = sc.nextInt();
			meet[i][1] = sc.nextInt();
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			meet[i][0] = Integer.parseInt(st.nextToken());
//			meet[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//arr[i][1] 순으로 오름차순 정렬 
		Arrays.sort(meet, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int end = 0;
		for(int i=0; i<n; i++) {
			if(meet[i][0] >= end) {
				end = meet[i][1];
				cnt++;				
			}
		}
		
		System.out.println(cnt);
	}
}
