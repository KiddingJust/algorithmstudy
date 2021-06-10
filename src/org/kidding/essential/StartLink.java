package org.kidding.essential;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StartLink {

	//조합으로 가능한 경우 추출
	//1234 -> (1,2)(3,4) (1,3)(2,4) (1,4)(2,3)
	//123456 -> (123, 124, 125 126, 134, 135, 136, 145, 146 156) -> 6C3
	// 4C2 / 2 = 3 6C3/2 = 6*5*4 / 3*2 / 2 
	
	//백트랙킹으로 하나씩 올리면서 하나씩 줄이기. 조합 어떻게 구해야하지.. 일단 모든 경우의 조합을 구하면
	//그 다음은? 조합 구하면서 합계도 구하기. 
	
	//boolean으로 true, false. -> 135 246 의 경우  13 15 35 
	//t t t f f f 
	//t t f t f f
	//t t f f t f
	//t t f f f t
	//t f t t f f
	
	// t t A t A t 
	// t t t B t B 
	// A t t t A t
	// t B t t t B
	// A t A t t t
	// t B t B t t
	
	public static ArrayList<Integer> answer = new ArrayList<Integer>();
	private static ArrayList<Integer> startT = new ArrayList<Integer>();
	private static ArrayList<Integer> linkT = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[n];

		combination(arr, visited, 0, n, n/2);
		
		Collections.sort(answer);
		int gmn = answer.get(0);
		bw.write(Integer.toString(gmn));
		bw.flush();
		bw.close();
	}
	
	//Combination 구하는 로직은 무조건 기억해두기. 
    static void combination(int[][] arr, boolean[] visited, int start, int n, int r) {

        if(r == 0) {
//        	//true면 start팀, false면 end팀
//            for(int i=0; i<visited.length; i++) {
//            	if(visited[i]==true) {
//            		startT.add(i);
//            	}else {
//            		linkT.add(i);
//            	}
//            }
//            System.out.println("startT: " + startT.toString());
//            System.out.println("linkT: " + linkT.toString());

            getDiffer(arr, visited, n);

            return;
        } else {
        	//n명으로 이루어진 인원을 2개의 팀으로 나누는 경우의 수 구하기. 
            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }	
    
    static void getDiffer(int[][] arr, boolean[] visited, int n) {
      
    	//Start팀과 L팀 각각 점수 합 구해주기 
    	int sumS = 0;
    	int sumL = 0;
      
    	for(int i=0; i<n; i++) {
    		if(visited[i] == true) {
    			for(int j=0; j<n; j++) {
    				if(visited[j] == true) {
    					sumS += arr[i][j];
    				}
    			}
    		}else {
    			for(int j=0; j<n; j++) {
    				if(visited[j] == false) {
    					sumL +=  arr[i][j];
    				}
    			}
    		}
    	}
      
    	int differ = Math.abs(sumS - sumL);
    	answer.add(differ);
      
    }
}
