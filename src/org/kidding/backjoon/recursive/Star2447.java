package org.kidding.backjoon.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Star2447 {
	
	static int count = 0;
	static ArrayList<String> result = new ArrayList<String>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int n = Integer.parseInt(br.readLine());
		
		Hanoi(n, 'A', 'B', 'C');
		
		bw.write(result.size());
//		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			bw.write(result.get(i));
//			System.out.println(result.get(i));
		}
		bw.flush();
		bw.close();
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
