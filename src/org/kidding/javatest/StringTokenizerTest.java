package org.kidding.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTokenizerTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
        int sCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 's') {
            }
        }
        
        List<Integer> list = new ArrayList<>();
//		Map<Integer, String> lanMap = new HashMap<>();
//		Map<Integer, String> fbMap = new HashMap<>();
//		Map<Integer, String> jsMap = new HashMap<>();
//		Map<Integer, String> foodMap = new HashMap<>();
//		Map<Integer, String> scoreMap = new HashMap<>();
//		
		String[] info = new String[6];
		String[] query = new String[6];
		
		Arrays.sort(info);
//		for(int i=0; i<info.length; i++) {
//			String[] temp = br.readLine().split(" ");
//			lanMap.put(i, temp[0]);
//			fbMap.put(i, temp[1]);
//			jsMap.put(i, temp[2]);
//			foodMap.put(i, temp[3]);
//			scoreMap.put(i, temp[1]);
//		}
		
		int[] answer = new int[6];
		
		for(int i=0; i<query.length; i++) {
			String[] qStr = query[i].split(" and ");
			for(int j=0; j<info.length; j++) {
				String[] inStr = info[i].split(" ");
				if(matchChk(qStr, inStr)) {
					answer[i]++;
				};
			}
		}
		
	}
	
	static boolean matchChk(String[] qStr, String[] inStr) {
		
		for(int i=0; i<qStr.length; i++) {
			if(qStr[i].equals("-")) {
				continue;
			}else if(qStr[i].equals(inStr[i])) {
				continue;
			}else {
				return false;
			}
		}
		
		return true;
	}
}
