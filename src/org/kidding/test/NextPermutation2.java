package org.kidding.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutation2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//일단 입력받는다. -> 그걸 배열에 넣는다
		//a[i-1] < a[i]이면 i 저장
		//가장 큰 i보다 큰 j 중에서 a[i] < a[j] 를 찾고 그중 가장 큰 j 구하기
		// i와 j를 swap. 
		// 그 다음에 a[i]부터 정렬해주면 되는데 어케 정렬할지는 모르겠음!. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] permu = new int[n];
		int maxIndex = 0;
		int swapIndex = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		for (int i=0; i<n; i++) {
	        permu[i] = Integer.parseInt(st.nextToken());
	        if (i > 0) {
	        	if(permu[i-1] < permu[i]) {
	        		maxIndex = i;
	        	}
	        }
		}
		System.out.println(Arrays.toString(permu));
		System.out.println(maxIndex);
		
		//다음 인덱스의 수가 더 큰 경우가 없을 땐 다음 순열 존재 X
		if(maxIndex == 0) {
			sb.append("-1");
	        bw.write(sb.toString());
	        bw.flush();
	        bw.close();	
		}else {
			
			//순차적으로 증가하는 경우 가장 마지막 두 개만 바꾸어주면 됨. 
			if(maxIndex == n-1) {
				swapIndex = maxIndex-1;
				System.out.println(swapIndex);

				int temp = permu[swapIndex];
				permu[swapIndex] = permu[maxIndex];
				permu[maxIndex] = temp;
				
				System.out.println("new:" + Arrays.toString(permu));
				
				//swap해주기. 
				int start = maxIndex;
		        int end = permu.length-1;
		        while (start < end) {
		            temp = permu[start];
		            permu[start] = permu[end];
		            permu[end] = temp;
		            start += 1;
		            end -= 1;
		        }
		        System.out.println("completed: " + Arrays.toString(permu));
		        
		        for(int i=0; i<permu.length; i++) {
		        	sb.append(permu[i] + " ");
		        }
		        
		        sb.delete(sb.length()-1, sb.length());
		        bw.write(sb.toString());
		        bw.flush();
		        bw.close();		
		        
			}else {

				for (int j=maxIndex+1; j<n; j++) {
					if (permu[j] > permu[maxIndex-1]) {
						swapIndex = j;
					}
				}
				
				//maxIndex보다 큰 인덱스에서 maxIndex의 수보다 큰 수가 없는 경우,
				//swapIndex를 maxIndex 이저느이 수로 잡아주기. 
				if (swapIndex == 0) {
					swapIndex = maxIndex;
				}
				
				System.out.println(swapIndex);

				int temp = permu[swapIndex];
				permu[swapIndex] = permu[maxIndex-1];
				permu[maxIndex-1] = temp;
				
				System.out.println("new:" + Arrays.toString(permu));
				
				//swap해주기. 
				int start = maxIndex;
		        int end = permu.length-1;
		        while (start < end) {
		            temp = permu[start];
		            permu[start] = permu[end];
		            permu[end] = temp;
		            start += 1;
		            end -= 1;
		        }
		        System.out.println("completed: " + Arrays.toString(permu));
		        
		        for(int i=0; i<permu.length; i++) {
		        	sb.append(permu[i] + " ");
		        }
		        
		        sb.delete(sb.length()-1, sb.length());
		        bw.write(sb.toString());
		        bw.flush();
		        bw.close();	
			}
		}
	}
}
