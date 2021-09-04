package org.kidding.codility.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermMissingElem {

	public static void main(String[] args) {
        // write your code in Java SE 8
		// 살짝 틀림. 1이 아니라 2가 없을수도 있음. 
        if(A.length == 1){
            return 1;
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i=1; i<=A.length+1; i++){
            hs.add(i);
        }

        for(int i=0; i<A.length; i++){
            hs.remove(A[i]);
        }
        List<Integer> answer = new ArrayList<>(hs);
        return answer.get(0);
        
        
        
        //지리는 정답. 
		int[] counters = new int[A.length+2];
		for (int i = 0; i < A.length; i++) {
			counters[A[i]] = 1;
		}
		for (int i = 1; i < counters.length; i++) {
			if (counters[i] == 0)
				return i;
		}
		//no element is missing
		return -1;
	}
}
