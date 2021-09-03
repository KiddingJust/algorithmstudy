package org.kidding.codility.test;

public class TapeEquilibrium {

	static int[] nums = {1, 2, 3, 4};
	
	public static void main(String[] args) {
        // write your code in Java SE 8
        //일단 idx 0빼고 다 더하기.
        //3 10 --> 7
        //그 다음은? 3 10-A[1]*2 --> 3 8 = 5
        //그 다음은? 3 8-A[2]*2 --> 3 4 = 1
        //그 다음은? 3 1-A[3]*2 --> 3 
        int left = 0;
        int total = 0;
        int answer = 999999;

        for(int n:A){
            total += n;
        }


        for(int i=0; i<A.length; i++){
            left += A[i];
            total -= A[i];
            int temp = Math.abs(left-total);
            if(temp < answer ){
                answer = temp;
            }else{
                return answer;
            }
        }

        return 1;
	}
}
