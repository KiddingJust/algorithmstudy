package org.kidding.test;

import java.util.Arrays;
import java.util.Scanner;

public class Dwarf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 9;
		int[] dwarf = new int[n];
		int sum = 0;
		int a = 0;
		int b = 0; 
		
		for(int i=0; i<n; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
		
		Arrays.sort(dwarf);
		
		for(int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if(sum - dwarf[i] - dwarf[j] == 100) {
					a = i;
					b = j;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if (i == a || i == b) { continue; }
			System.out.println(dwarf[i]);
		}
		
	}
}
