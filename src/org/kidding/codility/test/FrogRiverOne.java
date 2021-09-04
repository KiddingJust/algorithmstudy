package org.kidding.codility.test;

public class FrogRiverOne {

	public static void main(String[] args) {
        //1~X까지의 모든 수가 제거될 때  가능 
        HashSet<Integer> hs = new HashSet<>();
        for(int i=1; i<=X; i++){
            hs.add(i);
        }

        for(int i=0; i<A.length; i++){
            hs.remove(A[i]);
            if(hs.isEmpty()){
                return i;
            }
        }
        return -1;
	}
}
