package org.kidding.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/magic-square-forming/problem
public class MagicSquare {

	//마방진 문제. 경우의 수가 얼마 되지 않으므로 직접 만들어서 대조. 
	static int[][][] magicSquare = {
			{
				{8, 1, 6},
				{3, 5, 7},
				{4, 9, 2}
			},
			{
				{4, 3, 8},
				{9, 5, 1},
				{2, 7, 6}
			},
			{
				{2, 9, 4},
				{7, 5, 3},
				{6, 1, 8}
			},
			{
				{6, 7, 2},
				{1, 5, 9},
				{8, 3, 4}
			},
			{
				{6, 1, 8},
				{7, 5, 3},
				{2, 9, 4}
			},
			{
				{2, 7, 6},
				{9, 5, 1},
				{4, 3, 8}
			},
			{
				{4, 9, 2},
				{3, 5, 7},
				{8, 1, 6}
			},
			{
				{8, 3, 4},
				{1, 5, 9},
				{6, 7, 2}
			}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[3][3];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int min = 9999;
		for(int i=0; i<8; i++) {
			int sum = 0;
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					sum += Math.abs(arr[j][k]-magicSquare[i][j][k]);
				}
			}
			if(sum <= min) {
				min = sum;
			}
		}
		
		System.out.println(min);
	}
}
