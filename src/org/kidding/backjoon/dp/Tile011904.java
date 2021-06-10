package org.kidding.backjoon.dp;

import java.util.Scanner;

public class Tile011904 {

	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = -1;
		}
		arr[0] = 1;
		if(n==1) {
			System.out.println(1);
		}else if(n==2) {
			arr[1] = 2;
			System.out.println(2);
		}else {
			arr[1] = 2;
			System.out.println(getTile(n-1));
		}

	}
	
	//왜 마지막에 한 거랑 중간중간 과정마다 한 거랑 값이 다르지....? 
	static int getTile(int a) {
		if(arr[a] == -1) {
			arr[a] = (getTile(a-1) + getTile(a-2))%15746;
		}
		return arr[a];
	}
}
