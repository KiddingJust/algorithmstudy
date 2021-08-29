package org.kidding.z.checkpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SpecificShortestPath1504 {
	
	static ArrayList<EdgeSpecific>[] edge;
	static int[] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edge = new ArrayList[N];
		for(int i=0; i<N; i++) {
			
		}
		
		
		for(int i=0; i<E; i++) {
			
		}
	}
	
}

class EdgeSpecific{
	
	int to;
	int dist;
	
	public EdgeSpecific(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}