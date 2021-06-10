package org.kidding.programmers.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Developing42586 {

	static int[] progresses = {95, 90, 99, 99, 80, 99};
	static int[] speeds = {1, 1, 1, 1, 1, 1};
	public static void main(String[] args) {
	
		Queue<Integer> done = new LinkedList<>();
		int doneIdx = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(true) {
			boolean chkQueue = false;
			int cnt = 0;
			for(int i=0; i<progresses.length; i++) {
				progresses[i] += speeds[i];
				if(progresses[doneIdx] >= 100) {
					chkQueue = true;
					done.add(i);
					doneIdx++;
				}

			}
			
			if(chkQueue == true) {
				while(!done.isEmpty()) {
					done.poll();
					cnt++;
				}
				answer.add(cnt);
			}
			
			if(doneIdx >= progresses.length) {
				break;
			}
		}
		
        int[] answers = new int[answer.size()];
        
		for(int i=0; i<answer.size(); i++) {
			answers[i] = answer.get(i);
		}
			
		
	}
}
