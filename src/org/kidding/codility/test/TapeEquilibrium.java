package org.kidding.codility.test;

public class TapeEquilibrium {

	static int[] nums = {1, 2, 3, 4};
	
	public static void main(String[] args) {
        int left = 0;
        int total = 0;
        int answer = 999999999;

        for(int n:A){
            total += n;
        }

        //-1까지 하는 이유는? 아 그냥 조건이 그렇네 
        //[3, 5, 8, -100]
        //3 -87 --> 90
        //8 -82 --> 90
        //16 -74 --> 90
        // -84 -71 
        for(int i=0; i<A.length-1; i++){
            left += A[i];
            total -= A[i];
            int temp = Math.abs(left-total);
            if(temp < answer ){
                answer = temp;
            }
        }

        return answer; 
	}
}
