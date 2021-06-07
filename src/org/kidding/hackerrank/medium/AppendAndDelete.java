package org.kidding.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerrank.com/challenges/append-and-delete/problem?h_r=next-challenge&h_v=zen
public class AppendAndDelete {
	
	//문자 맨 마지막에 알파벳을 추가하거나 마지막 알파벳을 제거.
	//empty string에도 제거할 수 있음 (그대로 empty) 
	//s를 t로 바꿀 때 k번 움직임으로 바꿀 수 있는가. 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int k = Integer.parseInt(br.readLine());
		
		//순회하면서, 문자가 다른 index를 찾는다. 
		String[] sArr = s.split("");
		String[] tArr = t.split("");
		
		int answer = 0;
		
		//s의 문자열이 더 크면, 
		if(sArr.length >= tArr.length) {
			for(int i=0; i<tArr.length; i++) {
				if(!sArr[i].equals(tArr[i])){
					answer = (tArr.length-i)*2;
					break;
				}
			}
			answer += sArr.length-tArr.length;
		}else {
			for(int i=0; i<sArr.length; i++) {
				if(!sArr[i].equals(tArr[i])){
					answer = (sArr.length-i)*2;
					break;
				}
			}	
			answer += tArr.length-sArr.length;
		}
		System.out.println("answer: " + answer);
		//k보다 크기만 하면 무조건 가능? 
		//aaaa
		//aaa
		//6  --> 이건 불가능.
		//aaa
		//aa
		//6 --> 이건 가능. 
		if(answer > k) {
			System.out.println("No");
		}else if((k-answer)%2 != 0 && (sArr.length+tArr.length)>k){
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}

}
