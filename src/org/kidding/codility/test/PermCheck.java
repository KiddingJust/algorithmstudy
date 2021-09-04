package org.kidding.codility.test;

public class PermCheck {

	public static void main(String[] args) {
        //1 to N at once 
        //특정 num이  빠지면 permutation이 아님. 
        Arrays.sort(A);
        for(int i=0; i<A.length; i++){
            if(A[i] != i+1){
                return 0;
            }
        }
        return 1;
	}
}
