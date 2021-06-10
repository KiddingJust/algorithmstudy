package org.kidding.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Profit1712 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//이건 한줄만 입력받고, 각 위치의 수가 무엇을 의미하는지 정해져있으므로 array로 받기 
		
		String[] arr = br.readLine().split(" ");
		int fixCost = Integer.parseInt(arr[0]);
		int varCost = Integer.parseInt(arr[1]);
		int price = Integer.parseInt(arr[2]);
		
		//아래와 같은 방법도 가능. 참고해두기
//		int A = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//		int C = Integer.parseInt(st.nextToken());
		
		int i=1;
		boolean hasProfit = true;
		
		if(price <= varCost) {
			hasProfit = false;
			System.out.println("-1");
			return;
		}
		
//		(price-varCost)*i > fixCost
//		i > fixCost / (price-varCost)
//		1 > fixCost / (price-varCost)i
        System.out.println((fixCost/(price-varCost))+1);

		while(hasProfit) {	
			if((price*i) > fixCost + (varCost*i)) {
				System.out.println(i);
				break;
			}else {
				i++;
			}			
		}
		
	}
	
}