package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fraction1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int range = 1;
		int inc = 1;
		
		if(n == 1) {
			System.out.println("1/1");
		}else {
			while(n>range) {
				inc++;
				range = range + inc;
			}
			if(inc%2 == 1) {
				System.out.println((range-n+1) +"/" + (inc-(range-n)));
			}else {
				System.out.println((inc-(range-n)) +"/" + (range-n+1) );

			}
		}
	}
}
