package org.kidding.hackerrank.certification.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoadRepair {
	
	//1, 3, 5에 수리공 위치 
	//3, 5, 7 수리해야됨. 
	//한명의 수리공이 한곳을 수리 
	// 그럼 1->3, 3->5, 5->7 로 최소 이동이 6이 됨.
	static List<Integer> crew_id = Arrays.asList(5, 3, 1, 4, 6);
	static List<Integer> job_id = Arrays.asList(9, 8, 3, 15, 1);

	public static void main(String[] args) {
		
		//최솟값을 어떻게 구하지. 
		//음... 1, 3, 4, 5, 6 
		//     1, 3, 8, 9, 15 
		//정렬한 후에 고고 
		Collections.sort(crew_id);
		Collections.sort(job_id);
		long sum = 0;
		
		for(int i=0; i<crew_id.size(); i++) {
			sum += Math.abs(job_id.get(i)-crew_id.get(i));
		}
		
		System.out.println(sum);
		
		
	}
}
