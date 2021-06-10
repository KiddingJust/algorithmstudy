package org.kidding.lowlevelpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinMax {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//StringTokenizer 모를 때의 풀이 
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());	
	    String[] arrStr = br.readLine().split(" ");
		
	    int[] arr = new int[n];

		for(int i=0; i<n; i++) {
	    	arr[i] = Integer.parseInt(arrStr[i]);
	    }
		Arrays.sort(arr);
		System.out.println(arr[0] + " " + arr[n-1]);
		
		//////////////////////////////////////////////////////////////////////////
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br2.readLine());
		int[] arr2 = new int[N];
		//병렬식으로 입력받을 땐 StringTokenizer 써주는 게 좋음. 공백 단위로 읽어들이겠다. 
		StringTokenizer st = new StringTokenizer(br2.readLine(), " ");
		
		int index = 0;
		while(st.hasMoreTokens()) {
			arr2[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		Arrays.sort(arr2);
		System.out.println(arr2[0] + " " + arr2[N-1]);
		
		//////////////////////////////////////////////////////////////////////////
		// 배열 없이 만들어보기 
		//////////////////////////////////////////////////////////////////////////
		
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		int n3 = Integer.parseInt(br3.readLine());
		StringTokenizer st3 = new StringTokenizer(br3.readLine(), " ");
		
		int min = 1000000;
		int max = -1000000;
		
		while(st3.hasMoreTokens()) {
			int num = Integer.parseInt(st3.nextToken());
			
			if(num <= min) {
				min = num;
			}
			if(num >= max) {
				max = num;
			}
		}
		
		System.out.println("min: " + min + ", max: " + max);
		
		///////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////
	    // MAX의 위치 구하기 
		///////////////////////////////////////////////////////////
		
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
		int[] arr4 = new int[9];
		int min2 = 0;
		int answer = 0;
		
		for (int i=0; i<9; i++) {
			arr4[i] = Integer.parseInt(br4.readLine());
			if(arr4[i]>=min2) {
				min2 = arr4[i];
				answer = i+1;
			}
		}
		System.out.println(min2);
		System.out.println(answer);
		
		
		
		
		
		
		
	}
	

}
