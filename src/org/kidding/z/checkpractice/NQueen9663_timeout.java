package org.kidding.z.checkpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NQueen9663_timeout {
	
	static int totalNum = 0;
	
	public static void main(String[] args) {
		//첫째줄에 넣을 수 있는 것부터 고민. 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> cheseu = new HashMap<>();
		for(int i=0; i<n; i++) {
			cheseu.put(0, i);
			nQueen(cheseu, 1, n);
//			아래와 마찬가지 이유에서 필요 X
//			cheseu = new HashMap<>();
		}
		
		System.out.println(totalNum);
	}
	
	static void nQueen(Map<Integer, Integer> cheseu, int col, int n) {
		if(col == n) {
			totalNum++;
		}
		for(int i=0; i<n; i++) {
			if(diag(cheseu, i, col) == true ) {
				cheseu.put(col, i);
				nQueen(cheseu, col+1, n);
//				이게 필요 없는 이유는???? remove 하지 않아도, 3칼럼엔 다음 i로 바뀌기 때문! 
//				cheseu.remove(col);		
			}
		}
	}
	
	static boolean diag(Map<Integer, Integer> cheseu, int row, int col) {
		for(int i=0; i<col; i++) {
			if(Math.abs(row-cheseu.get(i)) == Math.abs(col-i)) {
				return false;
			}
            if(cheseu.get(i) == row){
                return false;
            }
		}
		return true;
	}
}