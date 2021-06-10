package org.kidding.test;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[4];

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		arr[0] = x;
		arr[1] = y;
		arr[2] = w-x;
		arr[3] = h-y;
		
		int temp = arr[0];

		for(int i=0; i<arr.length-1; i++) {
			if(temp > arr[i+1]) {
				temp = arr[i+1];
			}
		}
		
		System.out.println(temp);
	}
}

//아래와 같은 방법으로도 가능

//int x = in.nextInt();
//int y = in.nextInt();
//int w = in.nextInt();
//int h = in.nextInt();
//
//int vert = -1;
//int hori = -1;
//
//if(x > w/2) hori = Math.abs(w-x);
//else hori = x;
//
//if(y > h/2) vert = Math.abs(h-y);
//else vert = y;
//
//System.out.println(hori>vert?vert:hori);
