package org.kidding.test;

import java.io.IOException;
import java.util.Scanner;

public class Decomposition {
	
	//분해합 구하기
	//256 = 245+2+4+5, 
	//245의 분해합은 256, 256의 생성자는 245. 
	//11+1+1 = 13, 15+1+5 = 21 흐음... 
	//1부터 100만까지니까, 1부터 100만까지 입력받은 후, 쪼개서 분해합을 만들고 흐음..
	//아냐 이건 진짜 100만을 다 구하는 것이므로 효율적
	//끊었을 때 두번째 수가 2보다 크면, 2보다 작은 것중에서 고르면 됨. 
	//아니면? 다 구해봐야해. 210 = 204 + 2 + 0 + 4, 195 1 + 9 + 5 이렇게 되므로! 
	// 205 
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int answer = 0;
		
		for(int i=input-1; i>0; i--) {
			int decomp = i;	//input: 245
			int div = i;
			while(div != 0) {
				decomp += div%10;	// 245 + 5 -> +4 -> +2
				div /= 10;			// 245 / 10 = 24 
			}
			if (decomp == input) {
				answer = i;
			}
		}
        
		System.out.println(answer);
	}
}
