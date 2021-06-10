package org.kidding.test;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String args[]) {

    	ArrayList<Integer> result = new ArrayList<Integer>();
        int number = 0;
    	int index = 0; 
        
        //에라토노스의 체 활용. 가장 작은 수부터 시작해서 소수만 남겨두기.
        //boolean의 배열을 만들어줌. 
        int m = 123456 * 2;
        boolean[] check = new boolean[m+1];

        //초기화 하기. false인 경우가 소수. 0과 1은 소수가 아니므로 true
        //boolean의 default는 false이므로 true로 지정. 
        check[0] = check[1] = true;
            
        // 2부터 시작. 
        for (int i=2; i*i <= m; i++) {              
    	//소수가 아니면 넘어감. 
        	if (check[i] == true) {
                continue;
            }
        	// 2부터 시작. 2는 소수이므로 2의 배수는 모두 지워줌 (true)
        	for (int j=i+i; j<=m; j+=i) {
        		check[j] = true;
        	}
        }
        
    	Scanner sc = new Scanner(System.in);

        while(true) {
        	//스캐너 입력
        	
            int n = sc.nextInt();
            int nn = n * 2;
            
            if(n ==0) {
            	break;
            }
            
            if(n == 1) {
            	number = 1;
            }
            
            for(int i=n+1; i<nn; i++) {
            	if(check[i]==false) {
            		number++;
            	}
            }
            result.add(index, number);
            
            number = 0;
            index++;
        }
        
        for(int i=0; i<result.size(); i++) {
        	System.out.println(result.get(i));
        }
    }	
}
