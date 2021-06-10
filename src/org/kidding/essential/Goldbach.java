package org.kidding.essential;

import java.util.ArrayList;
import java.util.Scanner;

public class Goldbach {
	static int MAX = 1000000;
	
    public static void main(String args[]) {
        
    	Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX+1];
        //길이 모르므로 그냥 ArrayList로 
        ArrayList<Integer> prime = new ArrayList<Integer>();
        check[0] = check[1] = true;
        
        //1~100까지라 할 때, 11부터는 굳이 진행해줄 필요 없음. 
        for (int i=2; i*i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            } 
            
            //check[i]가 false이면 배수들을 모두 지워줌. 소수가 아니므로. 
            for (int j=i+i; j<=MAX; j+=i) {
                check[j] = true;
            }
        }
        
        for(int i=0; i<check.length; i++) {
        	if(check[i] == false) {
        		prime.add(i);
        	}
        }
        
         
        while(true) {
        	int n = sc.nextInt();
        	if(n == 0) {
        		break;
        	}
        	for (int i=1; i<prime.size(); i++) {
        		int pnum = prime.get(i);
        		if(check[n-pnum] == false) {
        			System.out.println(n + " = " + pnum + " + " + (n-pnum));
        			break;
        		}
        	};
        }
    }
}
