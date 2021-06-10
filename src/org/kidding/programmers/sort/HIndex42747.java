package org.kidding.programmers.sort;

import java.util.Arrays;

public class HIndex42747 {

	static int[] citations = {4, 4, 4, 5, 0, 1, 2, 3};
	
	public static void main(String[] args) {
		
		int answer = 0;
		
		Arrays.sort(citations);
		
        int max = 0;
	        for(int i = citations.length-1; i > -1; i--){
	        	System.out.println("citations[i]: " + citations[i]);
	        	System.out.println("citations.length - i: ");
	        	System.out.println(+ citations.length - i);
	            int min = (int)Math.min(citations[i], citations.length - i);
	            if(max < min) max = min;
	        }
	        
	     System.out.println(max);
//		int len = citations.length;
//		
//		Loop1 :
//		for(int i=len-1; i>=0; i--) {
//			System.out.println("i: " + i);
//			if(i == 0) {
//				for(int j=citations[i]; j>=0; j--) {
//					System.out.println("j: " + j);
//					System.out.println(len-i+1);
//					if(j<=len-i) {
//						answer = j;
//						break Loop1;
//					}
//					continue;
//				}
//			}
//			for(int j=citations[i]; j>citations[i-1]; j--) {
//				System.out.println("j: " + j);
//				System.out.println(len-i+1);
//				if(j<=len-i) {
//					answer = j;
//					break Loop1;
//				}
//			}
//		}
//		
//		System.out.println(answer);
		
	}
	
}
