package org.kidding.programmers.stackandqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Scoville_PriorityQueue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] scoville = new int[3];
		int K = sc.nextInt();
		for(int i=0; i<scoville.length; i++) {
			scoville[i] = sc.nextInt();
		}
		int answer = 0; 
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int n:scoville) {
			pq.add(n);
		}
		
		while(!pq.isEmpty()) {
            if(pq.peek() >= K){
                break;
            }else{
        		if(pq.size() == 1) {
				   answer = -1;
				   break;
			    }
    			int a = pq.poll();
	    		int b = pq.poll();
		    	int num = a+b*2;
//	    		if(num < K) {	1, 1,1 이 남아있는 경우 이렇게 하면 똥망. 
	    			pq.add(num);
//	    		}
	    		answer++;
            }
		}
		
		System.out.println(answer);
		
	}
}
