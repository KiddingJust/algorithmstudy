package org.kidding.backjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	
	static int answer[];
	//만들어주는 이유는 arr의 정답을 계속해서 담아야하기 때문. 
	//순서 정렬이 된 후에 arr에 반영해야함. arr에서 계속 같이 정렬하면, 숫자가 뒤바뀜. 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		answer = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("origin: " + Arrays.toString(arr));

		mergeSort(arr, 0, arr.length-1);

		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void mergeSort(int arr[], int from, int to) {
		int mid;
		
		if(from < to) {
			mid = (from + to)/2;
			mergeSort(arr, from, mid);
			mergeSort(arr, mid+1, to);
			merge(arr, from, mid, to);
		}
	}
	
	public static void merge(int arr[], int from, int mid, int to) {
		int frontF = from;
		int backF = mid + 1;
		int index = from;
		
		while(frontF<=mid && backF<=to) {
			System.out.println("frontF: " + frontF + " backF: " + backF);
			if(arr[frontF]<=arr[backF]) {
				answer[index] = arr[frontF];
				frontF++;
			}else {
				answer[index] = arr[backF];
				backF++;
			}
			System.out.println("A index: " + index + "answer: " + Arrays.toString(answer));
			index++;
		}
			
		if(frontF>mid) {
			for(int i=backF; i<=to; i++, index++) {
				answer[index] = arr[i];
				System.out.println("F index: " + index + "answer: " + Arrays.toString(answer));
			}
		}else {
			for(int i=frontF; i<=mid; i++, index++) {
				answer[index] = arr[i];
				System.out.println("B index: " + index + "answer: " + Arrays.toString(answer));
			}
		}
		
		for(int i=from; i<=to; i++) {
			arr[i] = answer[i];
		}
		System.out.println("arr변경: " + Arrays.toString(arr));
		System.out.println("answer[]: " + Arrays.toString(answer));
		
		
	}
}
