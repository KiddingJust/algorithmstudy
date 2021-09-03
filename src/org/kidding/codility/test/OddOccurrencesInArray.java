package org.kidding.codility.test;

import java.util.ArrayList;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
        // write your code in Java SE 8
		
        boolean[] isPair = new boolean[A.length];
        //bruteforce 하되, 같은 값이 나면 그  값도 isPair=true 해서 pass?
        for(int i=0; i<A.length-1; i++){
            if(!isPair[i]){
                // System.out.println("i: " + i);
                int num = A[i];
                // System.out.println("num: " + num);
                for(int j=i+1; j<A.length; j++){
                    if(num == A[j] && isPair[j] == false){
                        // System.out.println("j : " + j);
                        isPair[i] = true;
                        isPair[j] = true;
                        break;
                    }
                }
            }else{
                continue;
            }

            if(!isPair[i]){
                return A[i];
            }
        }
        
        return 0;
        
        //정답코드
        int answer = -1;
        HashSet<Integer> hs = new HashSet<>();

        int size = A.length;
        for(int i=0 ; i<size ; i++) {
            if( hs.contains(A[i]) ){
                //존재
                hs.remove(A[i]);
            }
            else {
                //없으면
                hs.add(A[i]);
            }
        }
        ArrayList<Integer> al = new ArrayList<>(hs);
        answer = al.get(0);
        return answer;
	}
}
