package org.kidding.codility.test;

public class Lesson4_MissingInteger {

	public static void main(String[] args) {
        //10만개까지 있는 배열
        //배열에 없는 양수 중 가장 작은 수 구하기. 
        //-1 3 5 --> 1
        //HashSet에 그냥 넣고 1부터 있나 체크? 
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<A.length; i++){
            if(A[i] > 0){
                hs.add(A[i]);
            }
        }
        int num = 0;
        while(num < 100000){
            num++;
            if(!hs.contains(num)){
                return num;
            }
        }

        return 1;
	}
}
