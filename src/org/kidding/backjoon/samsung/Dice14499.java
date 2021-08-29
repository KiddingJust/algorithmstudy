package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Dice14499 {
	
	static int[][] map;
	static String[] order;
	static int N;
	static int M;
	static int x;
	static int y;
	static int[][] dice = new int[4][3];
	
	//N x M 지도. 지도 좌표는 (r, c). 북쪽, 서쪽으로부터 떨어진 칸 갯수
	//가장 처음 주사위에는 모든 면에 0이 적혀져 있음. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
	    y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order = br.readLine().split(" ");
		List<Integer> answer = new ArrayList<>();
		
		for(int i=0; i<order.length; i++) {
			int result = roll(Integer.parseInt(order[i]));
			if(result != -1) {
				answer.add(result);
			}
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}

	}
	
	//1: y+ 2: y- 3: x- 4: x+
	//이거 방향은 굳이 설정 X
	//>> dx={0, 0, -1, 1}
	//>> dy={1, -1, 0, 0}
	//으로 해두고, 입력 받은 값이 1이면 nx = x + dx[입력-1], ny = y + dy[입력-1] 로 해주기. 
	static int roll(int dir) {		
		
		if(dir == 1) {
			y++;
			if(y>=M) {
				y--;
				return -1;
			}
			//주사위 평면도 변경
			dice = newDice(dice, dir);
			if(map[x][y]==0) {
				map[x][y] = dice[3][1];
			}else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
		}else if(dir == 2) {
			y--;
			if(y<0) {
				y++;
				return -1;
			}
			//주사위 평면도 변경
			dice = newDice(dice, dir);
			if(map[x][y]==0) {
				map[x][y] = dice[3][1];
			}else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
		}else if(dir == 3) {
			x--;
			if(x<0) {
				x++;
				return -1;
			}
			//주사위 평면도 변경
			dice = newDice(dice, dir);
			if(map[x][y]==0) {
				map[x][y] = dice[3][1];
			}else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
		}else {
			x++;
			if(x>=N) {
				x--;
				return -1;
			}
			//주사위 평면도 변경
			dice = newDice(dice, dir);
			if(map[x][y]==0) {
				map[x][y] = dice[3][1];
			}else {
				dice[3][1] = map[x][y];
				map[x][y] = 0;
			}
		}

		return dice[1][1];
	}
	
	//1: y+ 2: y- 3: x- 4: x+
	//0 2 0
	//4 1 3
	//0 5 0
	//0 6 0
	static int[][] newDice(int[][] preDice, int dir){
		//얕은복사와 깊은복사 차이 중요. newDice = preDice로 하면 newDice가 변경될 때 preDice도 변경됨. 
		int[][] newDice = new int[4][3];

		if(dir == 1) {
			newDice[1][0] = preDice[3][1];
			newDice[1][1] = preDice[1][0];
			newDice[1][2] = preDice[1][1];
			newDice[3][1] = preDice[1][2];
			
			newDice[0][1] = preDice[0][1];
			newDice[2][1] = preDice[2][1];
		}else if(dir == 2) {
			newDice[1][0] = preDice[1][1];
			newDice[1][1] = preDice[1][2];
			newDice[1][2] = preDice[3][1];
			newDice[3][1] = preDice[1][0];
			
			newDice[0][1] = preDice[0][1];
			newDice[2][1] = preDice[2][1];
		}else if(dir == 3) {
			newDice[0][1] = preDice[1][1];
			newDice[1][1] = preDice[2][1];
			newDice[2][1] = preDice[3][1];
			newDice[3][1] = preDice[0][1];
			
			newDice[1][0] = preDice[1][0];
			newDice[1][2] = preDice[1][2];
		}else {
			newDice[1][1] = preDice[0][1];
			newDice[2][1] = preDice[1][1];
			newDice[3][1] = preDice[2][1];
			newDice[0][1] = preDice[3][1];
			
			newDice[1][0] = preDice[1][0];
			newDice[1][2] = preDice[1][2];
		}
		
		return newDice;
	}
}
