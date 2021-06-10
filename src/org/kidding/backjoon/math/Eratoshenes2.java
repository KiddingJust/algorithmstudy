package org.kidding.backjoon.math;

import java.util.Scanner;

public class Eratoshenes2 {
	
	//m이상 n이하 소수를 모두 출력하기
	//n 이하의 갯수를 모두 지워준 후에, m이상만 따로 구해주면 된다. 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        //false인 경우가 소수. true는 지워짐. 
        boolean[] check = new boolean[n+1];
        
        check[0] = check[1] = true;
        
        //1~100까지라 할 때, 11부터는 굳이 진행해줄 필요 없음. 
        //처음에는 check[2] == false 이므로 다음 loop문 -> check[4] = true, check[6] = true...
        //루트 n보다 작은 i까지만 탐색하는 건 Prime.java 참고. 
        for (int i=2; i*i <= n; i++) {
        	System.out.println("i: " + i );
            if (check[i] == true) {
                continue;
            }
            //check[i]가 false이면 배수들을 모두 지워줌. 
            for (int j=i+i; j<=n; j+=i) {
                check[j] = true;
            }
        }
       
        for (int i=m; i<=n; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
        
        
    }
}
