package org.kidding.backjoon.sort;

import java.util.Scanner;

public class QuickSort2750 {


//    
//    public static void main(String[] args) {
//        
//        int data[] = {66, 10, 1, 34, 5, -10};
//        
//        sort(data, 0, data.length - 1);
//        for(int i=0; i<data.length; i++){
//            System.out.println("data["+i+"] : "+data[i]);
//        }
//    }

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
		
		int[] arr = {66, 10, 1, 34, 5, -10};
		
//		for(int i=0; i<n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		quickSort(arr, 0, arr.length-1);
		
      for(int i=0; i<arr.length; i++){
      System.out.println("data["+i+"] : "+arr[i]);
  }
//		for(int i=0; i<n; i++) {
//			System.out.println(arr[i]);
//		}
	}
	
	static void quickSort(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		int pivot = (left+right)/2;	//왜 이렇게 하면 안되고 arr[(left+right)/2] 를  pivot으로 하면 되는지 체크
		
		while(left<=right) {
			while(arr[left] < arr[pivot]) {
				left++;
			}
			while(arr[right] > arr[pivot]) {
				right--;
			}
			
			if(left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		};
		
		if(start<right) {
			quickSort(arr, start, right);
		}
		if(end>left) {
			quickSort(arr, left, end);
		}
	}
	
    static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
}

