package org.kidding.test;


// 이진 탐색의 탐색 시간은 'T = K * logN'으로 O(logN)이다
public class BinarySearch {

	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 7, 9, 13, 19, 22, 48, 52};

		binarySearch(48, arr);
	}
	
	
	public static void binarySearch(int key, int[] arr) {
		

		int left = 0;					//0 --> 5 --> 6
		int right = arr.length-1;		//
		int mid;
		
		while (left <= right) {
			
			mid = (left + right)/2;		//4	--> 6 --> 7
			
			if (key == arr[mid]) {
				System.out.println("index of " + key + " is: " + mid);
				break;
			} else if(key > arr[mid]) {
				left = mid + 1; // left = 5 --> 6
			} else {
				right = mid - 1;	//
			}
		};
		
	}
}
