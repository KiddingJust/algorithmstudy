package org.kidding.lowlevelpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] arr = new int[4];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		binarySearch(arr, inputNum);
		
	}
	
	public static void binarySearch(int[] arr, int answer) {
		Arrays.sort(arr);
		
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
				
		while (low <= high) {
			mid = (low+high)/2;
			if (answer > arr[mid]) {
				low = mid+1;
			}else if(answer < arr[mid]) {
				high = mid-1;
			}else {
				break;
			}	
		}		
	}
}
