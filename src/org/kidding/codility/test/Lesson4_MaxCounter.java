package org.kidding.codility.test;

import java.util.Arrays;

public class Lesson4_MaxCounter {
	
	public static void main(String[] args) {
		
        int[] counter = new int[N];
        //max 저장하고 있기
        int max = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] <= N){
                counter[A[i]-1]++;
                if(counter[A[i]-1] > max){
                    max = counter[A[i]-1];
                }
            }else if(A[i] == N+1){
                for(int j=0; j<counter.length; j++){
                    counter[j] = max;
                }
            }
        }

        return counter;
        
        
        //효율성 생각한 정답
        //currMin을 계속 생각해주기. counter ㅂ열을 다시 셋팅하지 말고,
        //currMin이라 하여 배열의 최솟값을최댓값으로 바꾸어주기
        //그리고 counter++ 때마다 curr min에서 ++ 해주기. 
		int[] counters = new int[N];
		int currMax = 0;
		int currMin = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i]<=N) {
				counters[A[i]-1] = Math.max(currMin, counters[A[i]-1]);
				counters[A[i]-1]++;
				currMax = Math.max(currMax, counters[A[i]-1]);
			}
			else if (A[i] == N+1) {
					currMin= currMax;
			}
		}
		
		for (int i = 0; i < counters.length; i++) {
			counters[i] = Math.max(counters[i], currMin);
		}
		return counters;
    }
}
