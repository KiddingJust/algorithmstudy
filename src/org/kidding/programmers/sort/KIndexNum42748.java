package org.kidding.programmers.sort;

import java.util.Arrays;

public class KIndexNum42748 {

	static int[] array = {1, 5, 2, 6, 3, 7, 4};
	static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
	
	public static void main(String[] args) {
		
		int[] answer = new int[commands.length];
		int answerIdx = 0;

		for(int i=0; i<commands.length; i++) {
			
			int start = commands[i][0];
			int end = commands[i][1];
			int findNum = commands[i][2];
				
			int[] tempArr = new int[end-start+1];
			int idx=0;
			for(int j=start-1; j<end; j++) {
				tempArr[idx++] = array[j];
			}
			Arrays.sort(tempArr);
			answer[answerIdx++] = tempArr[findNum-1];
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	/* 퀵정렬 메서드 참고 
    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
	 */
}
