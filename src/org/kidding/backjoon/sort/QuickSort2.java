package org.kidding.backjoon.sort;

public class QuickSort2 {
	 
    public static void main(String[] args) {
        
        int[] arr = { 10, 50, 20, 5, 70, 100 };
        
        quick_Sort(arr, 0, arr.length - 1);
        output(arr);
    }
 
    private static void quick_Sort(int[] arr, int start, int end) {
        
        int left = start;
        int right = end;
        /*pivot을 중앙 값으로 셋팅*/
        int pivot = arr[(left + right) / 2];
 
        do {
        	//왼쪽 맨끝에서부터 pivot보다 큰값찾기. 작으면 계속 탐색
            while (arr[left] < pivot) {
                left++;
            }
            //오른쪽 맨끝에서부터 pivot보다 작은값 찾기. 크면 계속 탐색. 
            while (arr[right] > pivot) {
                right--;
            }
            
            //         
            //왼쪽에서 더 큰값의 index가 오른쪽에서 더 작은 값의 index값보다 작으면, 
            //둘의 위치를 바꾸어준다. (그냥 큰 게 오른쪽으로, 작은 게 왼쪽으로 간다고 이해하면 됨)
            //그리고 이 경우에는 pivot보다 큰 값과 작은 값을 더 탐색할 수 있음. 고로 더 진행. 
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
 
        } while (left <= right);
 
        //그냥 큰부분과 작은부분을 퀵정렬 재귀호출 해주는 것. 잘 이해 안되면 외워. 
        //
        if (start < right) {
            quick_Sort(arr, start, right);
 
        }
        if (end > left) {
            quick_Sort(arr, left, end);
        }
    }
 
    private static void output(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}