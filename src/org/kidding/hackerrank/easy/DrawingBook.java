package org.kidding.hackerrank.easy;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/drawing-book/problem
public class DrawingBook {

	//총 페이지 수는 n. p라는 숫자에 도달하기 위해서는 최소 몇번 펼쳐야 하나? 
	//1부터 시작 or n부터 시작. 결국 둘중 하나인가?
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		int front = p/2;	//9의 경우, (9-1)/2 해서 4가 되면 가장 적게 넘긴 것. int니 그냥 나누어도 무방 
		int back = n/2-front;
		//계산해보자. 아 front를 구했으니 end도 되네. n/2-front 
		
		Math.min(front, back);
	}
}
