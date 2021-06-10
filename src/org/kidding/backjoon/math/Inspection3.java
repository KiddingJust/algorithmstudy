package org.kidding.backjoon.math;
    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
    
public class Inspection3 {
    
	// 2 -> 5, 9  output: 2, 4 // 3 -> 6, 34, 94   // 28 60
	// 2 - > 5, 13 인 경우 output으로 8도 되나? 되겠지. 2, 4, 8
	// 1. 먼저 최소의 수를 구한다
	// 2. 그 수를 그 수보다 작은 수로 나누어주고 나머지를 구한다. 
	// 3. 나머지 수를 루프문을 돌면서 나머지가 같다면 pass해준다
	// 4. pass를 하다가 마지막 index도 같아지면 끗
	// A[i] - A[i-1] 을 모두 구하고 각 수들의 최대공약수를 구하면?
	
	//약수 넣을 곳 
	private static ArrayList<Integer> divisor = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
    
		int[] temp = new int[n-1];
		for(int i=0; i<arr.length-1; i++) {
			temp[i] = arr[i+1]-arr[i];
		}
		
		int gcd = temp[0];
		
		//여러 수의 최대공약수 구하기. 이것도 필수
		for(int i=0; i<temp.length-1; i++) {
			gcd = gcd(gcd, temp[i+1]);
		}
		
		getDivisor(gcd);
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<divisor.size(); i++) {
			sb.append(divisor.get(i)+" ");
		}
		
		sb.substring(sb.length()-1, sb.length());	
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	
	}
	
	public static ArrayList<Integer> getDivisor(int GCD){	
		for(int i=1; i<=GCD; i++) {
			if(GCD%i == 0) {
				divisor.add(i);
			}
		}
		return divisor;
	}
	
	//최대공약수 구하는 로직 필수
	public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }
	
	
}
