package org.kidding.programmers.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestExam42840 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] answers = new int[n];
		for(int i=0; i<n; i++) {
			answers[i] = sc.nextInt();
		}
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[] cnt = new int[3];
		
		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;
		
		for(int i=0; i<answers.length; i++) {
			if(aIdx == 5) {
				aIdx = 0;
			}
			if(bIdx == 8) {
				aIdx = 0;
			}
			if(cIdx == 10) {
				cIdx = 0;
			}
			
			if(a[aIdx] == answers[i]) {
				cnt[0]++;
			}
			
			if(b[bIdx] == answers[i]) {
				cnt[1]++;
			}
			
			if(c[cIdx] == answers[i]) {
				cnt[2]++;
			}
			aIdx++;
			bIdx++;
			cIdx++;
		}
		
		int max = 0;
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i] >= max) {
				max = cnt[i];
			}
		}

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==cnt[0]) list.add(1);
        if(max==cnt[1]) list.add(2);
        if(max==cnt[2]) list.add(3);

        int [] answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }

		
		System.out.println(Arrays.toString(answer));	
	}
	
	
	/*
	    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1,2,3,4,5}; //이만큼씩 반복
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int answer1=0, answer2 =0, answer3 =0;
        
        for(int i =0; i<answers.length; i++){
            if(person1[i%person1.length] == answers[i]) answer1++;
            if(person2[i%person2.length] == answers[i]) answer2++;
            if(person3[i%person3.length] == answers[i]) answer3++;
        }
        int max = Math.max(Math.max(answer1, answer2),answer3); // max값 구하기
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==answer1) list.add(1); //max값이랑 같으면 넣는다.
        if(max==answer2) list.add(2);
        if(max==answer3) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    } 
	 
	 */
}
