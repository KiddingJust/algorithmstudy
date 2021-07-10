package org.kidding.z.checkpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NQueen9663 {
	
	static int totalNum = 0;
	
	public static void main(String[] args) {
		//첫째줄에 넣을 수 있는 것부터 고민. 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cheseu = new int[n];
		for(int i=0; i<n; i++) {
			cheseu[0] = i;
			nQueen(cheseu, 1, n);
//			cheseu = new HashMap<>();
		}
		
		System.out.println(totalNum);
	}
	
	static void nQueen(int[] cheseu, int col, int n) {
		if(col == n) {
			totalNum++;
		}
		for(int i=0; i<n; i++) {
			if(diag(cheseu, i, col) == true ) {
				cheseu[col] = i;
				nQueen(cheseu, col+1, n);
	
				}
		}
	}
	
	static boolean diag(int[] cheseu, int row, int col) {
		for(int i=0; i<col; i++) {
			if(Math.abs(row-cheseu[i]) == Math.abs(col-i)) {
				return false;
			}
            if(cheseu[i] == row){
                return false;
            }
		}
		return true;
	}
}