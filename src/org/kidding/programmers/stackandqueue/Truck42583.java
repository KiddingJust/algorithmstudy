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
	
		//�� ������ ������� �ٸ� �ǳʱ�. 
		int[][] arr = new int[truck_weights.length][2];
		
		for(int i=0; i<truck_weights.length; i++) {
			arr[i][0] = truck_weights[i];
		}
		
		//while 
		Queue<Integer> moveQ = new LinkedList<>();
		
		int sidx = 0;
		int fidx = 0;
		int totalTime = 1;	// ó�� 1�ʴ� �־��ֱ�
		int totalWgt = arr[0][0];	// �� ó�� ���� Ʈ�� ���� �־��ֱ�
		moveQ.add(0);		//�� ó�� �� �־��ְ� ���� 
		arr[0][1] = 1;
		int temp = 5;
		
		while(true) {

			//2�� �̻� �Ǹ� �ٸ�(ť)���� ���� 
			if(arr[moveQ.peek()][1] == bridge_length) {
				//�ٸ� �ǳʴ� Ʈ�� ���Կ��� ���ֱ�
				totalWgt -= arr[moveQ.peek()][0];
				//�ٸ����� ���ֱ�
				moveQ.poll();
				//start index ���� 
				sidx++;
			}
			
			//Ʈ�� �߰��� ���� �� �ֳ� ���. 
			if(fidx < arr.length-1) {
				if(totalWgt + arr[fidx+1][0] <= weight) {
					fidx++;
					moveQ.add(fidx);
					totalWgt += arr[fidx][0];
				}				
			}

			//�ǳʰ� �ִ� Ʈ�� �ð� ������ֱ� 
			for(int i=sidx; i<=fidx; i++ ) {
				arr[i][1]++;
			}
			
			//queue�� ��� ��� �Ǹ� finish
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
