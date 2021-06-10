package org.kidding.backhoon.essential.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class PairTomato{
	Integer x;
	Integer y;
	public PairTomato(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	public Integer first() {
		return x;
	}
	public Integer second() {
		return y;
	}
}

public class Tomato7576 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static ArrayList<PairTomato> oneList = new ArrayList<PairTomato>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		visited = new boolean[m][n];
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j] == 1) {
					oneList.add(new PairTomato(i, j));
				}
			}
		}
		
		//문제는 두군데서 동시에 시작할 수 있다는 것. 
		//bfs로 푸는 건 맞는데, 동시 시작하는 걸 생각해야함. 그리고 0일 때 탐색해야 함. -1이면 X. 
		//일단 1의 좌표를 다 넣어주기. 
		int allChk = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 0) {
					allChk++;
				}
			}
		}
		
		if(allChk == 0) {
			System.out.println(allChk);
			return;
		}
		
		int answer = bfs(arr, oneList, n, m);
		System.out.println(answer);
	}
	
	static int bfs(int[][] arr, ArrayList<PairTomato> oneList, int n, int m) {
		
		Queue<PairTomato> q = new LinkedList<PairTomato>();
		Queue<PairTomato> tempQ = new LinkedList<PairTomato>();

		int nx = 0;
		int ny = 0;
		
		for(int i=0; i<oneList.size(); i++) {
			q.offer(oneList.get(i));
		}
		int answer = 0;
		while(!q.isEmpty()) {
			PairTomato xy = q.poll();
			for(int i=0; i<4; i++) {
				nx = xy.first() + dx[i];
				ny = xy.second() + dy[i];
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
//					System.out.println("nx: " + nx + ", ny: " + ny);
					if(visited[nx][ny] == false && arr[nx][ny] == 0) {
						q.offer(new PairTomato(nx, ny));
						visited[nx][ny] = true;
						arr[nx][ny] = arr[xy.first()][xy.second()]+1;
					}
				}		
			}

		}
		
		int isPossible = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 0) {
					isPossible++;
					break;
				}else if(answer <= arr[i][j]) {
					answer = arr[i][j];
				}
				
			}
			if(isPossible > 0) {
				return -1;
			}
		}		
		return answer-1;
	}
}
