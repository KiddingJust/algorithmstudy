package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	Integer x;
	String y;
	public Pair(Integer x, String y) {
		this.x = x;
		this.y = y;
	}
	public Integer first() {
		return x;
	}
	public String second() {
		return y;
	}
}

class SnakePair{
	Integer x;
	Integer y;
	public SnakePair(Integer x, Integer y) {
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

public class Snake3190 {
	
	static int[][] arr;
	static int[][] snake;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		arr = new int[n+1][n+1];
		snake = new int[n+1][n+1];
		//int[][] arr, snake = new int[n+1][n+1] 이랑 무슨 차이? 
		snake[1][1] = 1;
		
		int aNum = Integer.parseInt(br.readLine());
		for(int i=0; i<aNum; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			arr[x][y] = 1;
		}
		
		int dNum = Integer.parseInt(br.readLine());
		Queue<Pair> dQ = new LinkedList<Pair>();
		for(int i=0; i<dNum; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			String y = temp[1];
			dQ.offer(new Pair(x, y));
		}
	
		
		//셋팅 끝 ////////////////////////////////////////////
		
		int answer = 0;
		String direction = "y+";
		int x = 1;
		int y = 1;
		Queue<SnakePair> snakeQ = new LinkedList<SnakePair>();
		snakeQ.add(new SnakePair(1,1));
		
		
		while(true) {		
			System.out.println("x: " + x + ", y: " + y);
			System.out.println("tailX: " + snakeQ.peek().first() + ", tailY: " + snakeQ.peek().second());
			System.out.println("answer: " + answer);
			
			//방향 순서는 맨 뒤로 가도 됨. 일단 현재 방향으로 가주고, 그다음에 전환하는 거니까..! 
			if(!dQ.isEmpty()) {
				if(answer == dQ.peek().first()) {
					System.out.println("방향 전환! ");
					direction = changeDirection(direction, dQ.peek().second());
					System.out.println("변경된 direction: " + direction);
					dQ.poll();
				}
			}

			answer++;

			int[] temp = move(direction, x, y);	//방향, 머리 좌표 
			x = temp[0];
			y = temp[1];
			snakeQ.offer(new SnakePair(x, y));
			System.out.println("변경된 위치 ==> x: " + x + ", y: " + y);
			if(temp[0]>=1 && temp[1]>=1 && temp[0] <= n && temp[1] <= n) {
				//뱀 몸통에 닿지 X
				if(snake[x][y] == 0) {
					if(arr[x][y] == 0) {
						System.out.println("사과 업성 ");
						//사과가 없는 경우
						snake[x][y] = 1;
						snake[snakeQ.peek().first()][snakeQ.peek().second()] = 0;
						//꼬리 위치 변경
						snakeQ.poll();	//기존 꺼리 제거
					}else {
						//사과가 있는 경우
						snake[x][y] = 1;
						//사과 먹었으니 사과 없애주기
						arr[x][y] = 0;
					}					
				}else {
					//몸통에 닿음. 
					break;
				}
			}else {
				//그리드 벗어남 
				break;
			}
			
		}//while end;
		
		System.out.println(answer);
	}
	
	static int[] move(String direction, int x, int y) {
		if(direction.equals("x+")) {
			x++;
		}else if(direction.equals("x-")){
			x--;
		}else if(direction.equals("y+")) {
			y++;
		}else {
			y--;
		}
		int[] xy = {x, y};
		
		return xy;
	}
	
	static String changeDirection(String direction, String change) {
		
		if(change.equals("D")) {
			if(direction.equals("x+")) {
				direction = "y-";
			}else if(direction.equals("x-")){
				direction = "y+";
			}else if(direction.equals("y+")) {
				direction = "x+";
			}else {
				direction = "x-";
			}	
		}else {
			if(direction.equals("x+")) {
				direction = "y+";
			}else if(direction.equals("x-")){
				direction = "y-";
			}else if(direction.equals("y+")) {
				direction = "x-";
			}else {
				direction = "x+";
			}		
		}
		
		return direction;
	}
}



/*
1. 방향 설정법. 
private static int nextDir(int current, int dir) {
	// current 현재, dir 다음 방향
	int next = (current + dir) % 4;
	if (next == -1) next = 3; return next;
}

2. 뱀 LinkedList 설정. 이렇게 하면 Queue처럼 사용하고 Pair 안써도 됨. 오호. 
snake = new LinkedList<>();
snake.add(new int[]{0, 0});

snake.add(new int[]{nextX, nextY});
snake.remove(0); 	//사과 없을 때만! 

for (int i = 0; i < snake.size(); i++) {
	// 뱀 몸통이랑 닿았는지
	int[] s = snake.get(i);
	if (s[0] == x && s[1] == y) return true;
}

3.quq도 for문 돌려서 체크 가능. 
for(Pair test:dQ) {
	System.out.println(test.first());
	System.out.println(test.second());
}


출처: https://leveloper.tistory.com/39 [꾸준하게]

 * */
