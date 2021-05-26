package org.kidding.programmers.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck42583 {

	static int bridge_length = 2;
	static int weight = 10;
	static int[] truck_weights = {7, 4, 5, 6};
	
//	static int bridge_length = 100;
//	static int weight = 100;
//	static int[] truck_weights = {10};
	
	public static void main(String[] args) {
	
		//위 정해진 순서대로 다리 건너기. 
		int[][] arr = new int[truck_weights.length][2];
		
		for(int i=0; i<truck_weights.length; i++) {
			arr[i][0] = truck_weights[i];
		}
		
		//while 
		Queue<Integer> moveQ = new LinkedList<>();
		
		int sidx = 0;
		int fidx = 0;
		int totalTime = 1;	// 처음 1초는 넣어주기
		int totalWgt = arr[0][0];	// 맨 처음 들어가는 트럭 무게 넣어주기
		moveQ.add(0);		//맨 처음 건 넣어주고 시작 
		arr[0][1] = 1;
		int temp = 5;
		
		while(true) {

			//2초 이상 되면 다리(큐)에서 제거 
			if(arr[moveQ.peek()][1] == bridge_length) {
				//다리 건너는 트럭 무게에서 빼주기
				totalWgt -= arr[moveQ.peek()][0];
				//다리에서 빼주기
				moveQ.poll();
				//start index 변경 
				sidx++;
			}
			
			//트럭 추가로 넣을 수 있나 계산. 
			if(fidx < arr.length-1) {
				if(totalWgt + arr[fidx+1][0] <= weight) {
					fidx++;
					moveQ.add(fidx);
					totalWgt += arr[fidx][0];
				}				
			}

			//건너고 있는 트럭 시간 계산해주기 
			for(int i=sidx; i<=fidx; i++ ) {
				arr[i][1]++;
			}
			
			//queue가 모두 비게 되면 finish
			if(moveQ.isEmpty()) {
				totalTime++;
				break;
			}
			
			totalTime++;
			temp--;
		}
		
		
		System.out.println(totalTime);
		
		
		
	}
}
