package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sugar2839 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//일반적으로 쉽게 계산해보면, N이 주어졌을 때 5로 나누고 나머지가 3의 배수로 빠지면
		//그 갯수를 구하면 됨. 
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int t = n;
		int a = 0;
		int b = 0;
		int tempAnswer = 0;
		
		// 18을 5로 나누어보기 
		// 5로 나누어지지 않는다면? 3으로 나누어보기 
		// 3으로 나누어지면? tempAnswer에 저장
		// 3으로 나누어지든 나누어지지 않든, 18-5를 해주고 다시 반복문 실행. 
		
		if (n%5 == 0) {
			System.out.println("5로나누어지므로 이거시 정답");
			System.out.println(n/5);
			System.out.println("=========================");
			return;
		}
		
		for (int i=0; i<=(t/5); i++) {
			n = t-(5*i);
			System.out.println("n: " + n );
			
			if (n%3 == 0) {
				
				System.out.println("3으로 나누어지니 tempAnswer 수정");
				System.out.println("5가 몇개 들어갔는지 + 남은 건 3kg 몇봉지인지 ");
				System.out.println(i + n/3);
				
				//5가 늘어날수록 무조건 전체 봉지 갯수는 작아지므로; 
				tempAnswer = i + n/3;
			}
						
		}
		
		System.out.println("결국 답은 ===== ");
		System.out.println( (tempAnswer > 0) ? tempAnswer : -1 );
		//이렇게 삼항연산자 안쓰고, 그냥 tempAnswer = -1로 초기화시켜주어도 될듯. 
		
		
//		for(int i=0; i<=(t/5); i++) {
//			n = t-(5*i);
//			System.out.println("n: " + n );
//			if((n%5)%3 == 0) {
//				a = (n/5) - i;
//				b = (n%5)/3;
//				System.out.println("a: " + a);
//				System.out.println("b: " + b);
//				break;
//			}
//			if(n%3 == 0) {
//				System.out.println("n%3으로 나누어 떨어질 ");
//				System.out.println(i + n/3);
//				tempAnswer = i + n/3;
//			}
//			if(i == t/5) {
////				if(t%3 == 0) {
////					System.out.println("여기안들어와?");
////					System.out.println(t/3);
////					return;
////				}
//				if(t%3 != 0 ) {
//					System.out.println("-1");
//					return;	
//				}
//			}
//		}
//		
//		if(a == 0 && b == 0) {
//			System.out.println(tempAnswer);
//		}else {
//			if(tempAnswer < a+b) {
//				System.out.println(tempAnswer);
//			}else {
//				System.out.println("a: " + a + ", b: " + b);
//				System.out.println(a+b);
//			}		
//		}

		
	}
	
}
