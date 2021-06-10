package org.kidding.test;

import java.util.ArrayList;
import java.util.Scanner;

public class HanoiTower2 {
        
	static int count = 0;
	static ArrayList<String> result = new ArrayList<String>();

	public static void main(String[] args) {		     
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Hanoi(n, 'A', 'B', 'C');
		
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
	
	//원판을 옮기는 함수를 Hanoi라 정의
	public static void Hanoi(int n, char A, char B, char C) {

		if(n == 1) {
			result.add(A+" "+C);
		}else {
			//(n-1)개의 원판을 옮기되 n-1개를 C로 옮기는 게 아닌 B로 옮기는 것으로
			Hanoi(n-1, A, C, B);
			//남은 1개의 원판은 C로 옮김.
			result.add(A+" "+C);
			//Move(A, C, n);
			//다시 n-1개의 원판을 옮기는 상황. A와 B의 위치는 바뀜. 
			Hanoi(n-1, B, A, C);
		}
	}            
}
