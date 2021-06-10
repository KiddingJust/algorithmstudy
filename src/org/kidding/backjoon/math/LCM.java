package org.kidding.backjoon.math;

import java.util.Scanner;

public class LCM {
	
	//유클리드 호제법 - GCD(a,b) = GCD(b,a%b)  
	//시간 복잡도는 O(log n) 
	public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int g = gcd(a, b);
            int l = a * b / g;	//최소공배수 = ( a * b / 최대공약수 )
            System.out.println(g);
            System.out.println(l);
            
    } 
}
