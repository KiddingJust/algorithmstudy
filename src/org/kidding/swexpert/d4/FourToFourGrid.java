package org.kidding.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV7I5fgqEogDFAXB&categoryId=AV7I5fgqEogDFAXB&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1

public class FourToFourGrid {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	//4x4 격자판. 0~9 사이 숫자 적힘 
	//6번 이동해서 7자리 숫자. 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();	
		
		int seq = 1;
		while(seq <= T) {
			int[][] map = new int[4][4];
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(seq+" ").append(bfs(map)).append("\n");		
			
			seq++;
		}
		
		System.out.println(sb);
	}
	
	static int bfs(int[][] map) {

		Map<String, Integer> result = new HashMap<>();
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {

				int startX = i;
				int startY = j;
				
				Queue<GridPair> q = new LinkedList<>();
				q.offer(new GridPair(startX, startY, Integer.toString(map[startX][startY])));
				while(!q.isEmpty()) {
					GridPair xy = q.poll();
					int x = xy.x;
					int y = xy.y;
					String num = xy.num;
					if(num.length() == 7) {
						if(result.get(num) == null) {
							System.out.println("num: " + num);
							result.put(num, 1);
						}
						continue;
					}
					
					for(int k=0; k<4; k++) {
						int nx = x+dx[k];
						int ny = y+dy[k];
						
						if(nx>=0&&ny>=0&&nx<4&&ny<4) {
							String s = num+Integer.toString(map[nx][ny]);
							q.offer(new GridPair(nx, ny, s));
						}
						//생각을 해보자. 
						//1 1 1 1
						//1 2 2 1
						//3 2 3 4
						//1 3 5 9
					}					
				}//end while
				
//			    for( String key : result.keySet() ){
//			          System.out.println( key);
//			    }
			}
		}
				
		int answer = result.size();

		return answer;
	}
}

class GridPair{
	int x;
	int y;
	String num;
	
	public GridPair(int x, int y, String num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}
