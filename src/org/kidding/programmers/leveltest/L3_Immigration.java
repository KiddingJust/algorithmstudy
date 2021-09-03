package org.kidding.programmers.leveltest;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/43238
public class L3_Immigration{


	static int[] times = {7, 10};
	static int n = 6; 
	public static void main(String[] args) {
	
        long answer = 0;
        
        Arrays.sort(times);
        long min = times[0];
        
        long num = n*min;
        answer = sol(n, times, 0, num/2, num);
        System.out.println(answer);
//        return answer;
    }
    
    static long sol(int n, int[] times, long start, long num, long end){
        System.out.println("start: " + start + ", num: " + num + ", end:" + end);

        if(start >= end) {
        	return num;
        }
        
        long sum = 0;
        for(int time:times){
            sum += num/time;
        }

        if(sum >= n){
            end = num;
            num = (start+end)/2;
        }else{
            //아직 n이 더 크면,
            start = num+1;
            num = (start+end)/2;
        }
        return sol(n, times, start, num, end);
    }
    
}

