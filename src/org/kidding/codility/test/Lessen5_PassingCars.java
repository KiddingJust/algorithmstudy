package org.kidding.codility.test;

public class Lessen5_PassingCars {

	public static void main(String[] args) {
        // 0 ->.  1 <-
        // 0은 자신보다 큰 인덱스에서 1로 가는 차량과 pair 관계 
		//정확성 100 /퍼포먼스 40 
        int sum = 0; 
        int temp=0;
        //방법 2. 
        for(int i=A.length-1; i>=0; i--){
            if(A[i] == 1){
                temp++;
            }else if(A[i] == 0){
                sum += temp;
            }
        }
        return sum;
         

        /* 맨 처음 풀이 --> 퍼포먼스 0ㅋㅋㅋㅋ*/
        /*
        for(int i=0; i<A.length; i++){
            if(A[i] == 0){
                for(int j=i+1; j<A.length; j++){
                    if(A[j] == 1) sum++;
                }
            }
        }
        return sum;
        */
	}
}
