package org.kidding.backjoon.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeStack10828 {
	
	private static int[] arr;
	private static int size;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    
	    arr = new int[n];
	    size = 0;	//가장 위의 수 추출용
	    
	    for(int i=0; i<n; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	switch(st.nextToken()) {
	    	case "push":
	    		push(Integer.parseInt(st.nextToken()));
	    		break;
	    	case "pop":
	    		pop();
	    		break;
	    	case "size":
	    		size();
	    		break;
	    	case "empty":
	    		empty();
	    		break;
	    	case "top":
	    		top();
	    		break;
	    	}
	    			

	    }
	    System.out.println(sb);
	    
	}
	
	static void push(int input) {
		arr[size] = input;
		size++;
		return;
	}
	
	static void pop() {
		if(size == 0) {
			sb.append("-1"+"\n");
			return;
		}
		int temp = arr[size-1];
		sb.append(temp+"\n");
		arr[size-1] = 0;
		size--;
	}
	
	static void size() {
		sb.append(size+"\n");
	}
	
	static void empty() {
		if(size == 0) {
			sb.append("1"+"\n");
		}else {
			sb.append("0"+"\n");
		}
	}
	static void top() {
		if(size == 0) {
			sb.append("-1"+"\n");
		}else {
			sb.append(arr[size-1]+"\n");
		}
	}
	
	
}
