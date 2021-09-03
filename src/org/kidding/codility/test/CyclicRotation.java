package org.kidding.codility.test;

import java.util.ArrayList;
import java.util.List;

public class CyclicRotation {

	public static void main(String[] args) {
        while(K>0){
        	
        	if(A.length == 0) {
        		return A;
        	}
            int temp = A[A.length-1];
            for(int i=A.length-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = temp;

            K--;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<A.length; i++) {
        	if(!list.contains(A))
        }list.in
        return A;
        
        

	}
}
