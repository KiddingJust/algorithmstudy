package org.kidding.codility.test;

public class BinaryGap {

	public static void main(String[] args) {
		
		int N = 1041;
		
        int max = 0;
        int length = 0;
        boolean flag = false;

        while(N != 0){ 
            if(N%2 == 0){
                if(flag){
                    length++;
                }
            }else{
                flag = true;
                if(length > max){
                    max = length;
                };
                length = 0;
            };

            N = N/2;
        };

        System.out.println(max);
    }		
}
