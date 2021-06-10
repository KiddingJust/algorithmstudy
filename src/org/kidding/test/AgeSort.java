package org.kidding.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AgeSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//member 정보 담기. 나이-이름-가입순
		String[][] member = new String[n][2];
		
		for(int i=0; i<n; i++) {
			member[i][0] = Integer.toString(sc.nextInt());
			member[i][1] = sc.next();
		}
		
	       Arrays.sort(member, new Comparator<String[]>() {
	            @Override
	            public int compare(String[] x, String[] y) {
	                
	            	return Integer.compare(Integer.parseInt(x[0]), Integer.parseInt(y[0]));
	
	            } 
	        });
	       
	       for(int i=0; i<member.length; i++) {
	    	   System.out.println(member[i][0]+" "+member[i][1]);
	       }
	}
	
}
