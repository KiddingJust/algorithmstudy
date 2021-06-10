package org.kidding.programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BestAlbum42579 {

	static String[] genres = {"A"};//{"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};//{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};//{"classic", "pop", "classic", "classic", "pop"};
	static int[] plays = {2500};//{500, 600, 150, 800, 1100, 2500, 100, 1000};//{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};//{500, 600, 150, 800, 2500};
	
	public static void main(String[] args) {
		int len = genres.length;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int[][] playCnt = new int[len][2];
		
		//장르별 총 플레이 수 저장 
		for(int i=0; i<len; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
		}
		
		//index와 play 수 배열로 저장 -> 정렬하기 위함. 
		for(int i=0; i<len; i++) {
			playCnt[i][0] = i;
			playCnt[i][1] = plays[i];
		}
		
		//o1-o2는 오름차순, o2-o1은 내림차순. 같을 때는 오름차순. 
		Arrays.sort(playCnt, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});
		
		System.out.println("playCnt 배열");
		for(int i=0; i<playCnt.length; i++) {
			System.out.println(playCnt[i][0] + ", " + playCnt[i][1]);
		}
		System.out.println("==============");
		
		//많이 재생된 장르 순서대로 배열에 정렬. 
		int cnt = map.size();
		int idx = 0;
		String[] maxGenre = new String[cnt];
		while(cnt>0) {
			int max = 0;
			String maxKey = "";
			for(String key:map.keySet()) {
				if(map.get(key)>=max) {
					max = map.get(key);
					maxKey = key;
				}
			}
			map.put(maxKey, 0);
			maxGenre[idx] = maxKey;
			idx++;
			cnt--;
		}
		
		
		ArrayList<Integer> tempAnswer = new ArrayList<Integer>();
//		int[] answer = new int[map.size()*2];
//		int answerIdx = 0;
		for(int i=0; i<maxGenre.length; i++) {
			System.out.println("i: " + i);
			int two = 0;
			for(int j=0; j<playCnt.length; j++) {
				System.out.println("j: " + j );
				if(two <= 1) {
					System.out.println("playCnt[j][0]: " + genres[playCnt[j][0]]);
					if(genres[playCnt[j][0]].equals(maxGenre[i])) {
						System.out.println("j: " + j + ", playCnt[j][0] = " + genres[playCnt[j][0]] + ", maxGenre[i]: " + maxGenre[i]);
						//answer[answerIdx] = playCnt[j][0];
						tempAnswer.add(playCnt[j][0]);
//						answerIdx++;
						two++;
					}
				}else {
					continue;
				}
			}
		}
		
		int[] answer = new int[tempAnswer.size()];
		
        for(int i = 0; i < tempAnswer.size(); i++){
            answer[i] = tempAnswer.get(i);
        }
		
		System.out.println(Arrays.toString(answer));
		
	}
}
