package org.kidding.programmers.leveltest;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/1830 졸라 어렵네..못품. 
public class L3_BrainsAdRemove {

	static StringBuilder sb = new StringBuilder();
	static String sentence = "xAaAbAaAx";
	public static void main(String[] args) {
		
		int start = 0;
		List<Character> preRule = new ArrayList<>();
		while(start < sentence.length()) {
//			System.out.println("start: " + start);
			if(start == sentence.length()-1) {
				break;
			}
			//규칙2 체크
			Character ruleSecondNum = sentence.charAt(start);
			//규칙2 적용 O 
			if(preRule.contains(ruleSecondNum)){
				sb.delete(0, sb.length());
				sb.append("invalid");
				break;
			}
			if(!Character.isUpperCase(ruleSecondNum)) {
				preRule.add(ruleSecondNum);
				int nextIdx = sentence.indexOf(ruleSecondNum, start+1);
				//규칙1 체크
				Character ruleFirstNum = sentence.charAt(start+2);
				//규칙 1 적용 O
				if(preRule.contains(ruleFirstNum)){
					sb.delete(0, sb.length());
					sb.append("invalid");
					break;
				}
				if(!Character.isUpperCase(ruleFirstNum)) {
					preRule.add(ruleFirstNum);
					for(int i=start+1; i<nextIdx; i++) {
						if(sentence.charAt(i) != ruleFirstNum) {
							sb.append(sentence.charAt(i));
						}
					}
				//규칙1 적용 X
				}else {
					for(int i=start+1; i<nextIdx; i++) {
						sb.append(sentence.charAt(i));
					}
				}
				//규칙2 닫히는 부분부터 다시 체크! 
				start = nextIdx+1;

				

			//규칙2 적용 X
			}else {
				//HaEaLaLaO			
				//규칙1 체크 . 다음 캐릭터가 소문자인가? 
				Character ruleFirstNum = sentence.charAt(start+1);
				//이전에 나온 문자열인 경우 invalid! 
				if(preRule.contains(ruleFirstNum)){
					sb.delete(0, sb.length());
					sb.append("invalid");
					break;
				}
				//규칙 1 적용 O
				//OxOxOxOx
				if(!Character.isUpperCase(ruleFirstNum)) {
					while(true) {
						if(start == sentence.length()-1) {
							sb.append(sentence.charAt(start));
							break;
						}
						
						if(start > sentence.length()-1) {
							sb.delete(0, sb.length());
							sb.append("invalid");		
							break;							
						}
						if(sentence.charAt(start+1) == ruleFirstNum) {
							sb.append(sentence.charAt(start));
							start = start+2;
						}else {
							sb.append(sentence.charAt(start));
							sb.append(" ");
							start = start+1;
							break;
						}
					}
				//규칙1 적용 X
				}else {
//					System.out.println("nothing rule");
				}
			}
		}
		String answer = "";
		answer = sb.toString();
		System.out.println(answer);
	}
}
