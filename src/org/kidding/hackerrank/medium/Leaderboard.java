package org.kidding.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class Leaderboard {

	//가장 top인 랭크는 1
	//같은 점수는 같은 랭킹이며, 그 다음 순위는 바로 다음 넘버
	//->  100, 90, 90, 80 점수일 때 랭킹은 1, 2,2, 3
	//다음 플레이어들이 70, 80, 105를 받으면 이들의 랭킹은 4, 3, 1 
	//전체는 105, 100, 90, 90, 80, 80,70 인데 70이 4인 이유는 105가 반영되기 전이기 때문
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> ranked = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			ranked.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer> scoreSet = new HashSet<Integer>(); 
		
		for(int i=0; i<ranked.size(); i++) {
			scoreSet.add(ranked.get(i));
		}
		
		ArrayList<Integer> scoreList = new ArrayList<Integer>(scoreSet);
		Collections.sort(scoreList, Collections.reverseOrder());
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		//binary search로 찾기. 근데 이건 그냥 찾는거고, 넣은 다음에 찾는 건 다른 문제인데...
		//정렬을 하고 binary search를 해야겠네.. 흠.. 
		for(int i=0; i<m; i++) {
			int score = Integer.parseInt(st.nextToken());
			if(score < scoreList.get(scoreList.size()-1)) {
				scoreList.add(score);
			}
			int answerIdx = getSearch(scoreList, score);
			answer.add(answerIdx);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}	
	}
	
	private static int getSearch(ArrayList<Integer> scoreList, int score) {
		
		int left = 0;
		int right = scoreList.size()-1;
		int mid = 0;
		
		//기존의 ranked에서 가장 낮은 점수일경우 길이가 1 추가됨. 
//		if(score < scoreList.get(right)) {
//			return right+2;
//		}
		//100 90 90 80 75 60
		//내림차순이므로 반대로 탐색.
		while(left <= right) {
			mid = (left+right)/2;
			if(score < scoreList.get(mid)) {
				left = mid+1;
			}else if(score > scoreList.get(mid)) {
				right = mid-1;
			}else {
				break;
			}
		}
		
		if(score < scoreList.get(mid)){
			mid++;
		}
		
		//순위이므로 index+1 해주기. 
		return mid+1;
	}
/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		//넣고, 정렬한 후에, 해당 값을 찾기? 음. 
		//index의 경우에는, 값이 같다면 높이지 말기.
		for(int i=0; i<m; i++) {
			int idx = 0;
			int lastScore = 0;	//지난 점수. 
			int score = Integer.parseInt(st.nextToken());
			list.add(score);
			for(int j=0; j<list.size(); j++) {
                int chkScore = list.get(j);
                if(chkScore == lastScore){
                    continue;
                }else if(chkScore <= score) {
                    idx++;
                    break;
                }
                idx++;
                lastScore = chkScore;
			}
			answer.add(idx);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}	
	}
 */
/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		//넣고, 정렬한 후에, 해당 값을 찾기? 음. 
		//index의 경우에는, 값이 같다면 높이지 말기.
		for(int i=0; i<m; i++) {
			int idx = 0;
			int lastScore = 0;	//지난 점수. 
			int score = Integer.parseInt(st.nextToken());
			list.add(score);
			Collections.sort(list, Collections.reverseOrder());
			for(int j=0; j<list.size(); j++) {
                int chkScore = list.get(j);
                if(chkScore == lastScore){
                    continue;
                }else if(chkScore == score) {
                    idx++;
                    break;
                }
                idx++;
                lastScore = list.get(j);
			}
			answer.add(idx);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}		
	}
 */
}
