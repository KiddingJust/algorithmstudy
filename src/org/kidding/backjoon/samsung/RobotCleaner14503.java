package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PairRobot{
	Integer x;
	Integer y;
	
	public PairRobot(Integer x, Integer y) {
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

public class RobotCleaner14503 {
	
	static int cnt = 1;
	static int dir;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(x, y); 
		
		System.out.println(cnt);

	}
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		
		Queue<PairRobot> q = new LinkedList<PairRobot>();
		q.offer(new PairRobot(x, y));
		
		while(!q.isEmpty()) {
			System.out.println("탐색 지점: " + q.peek().x + ", " + q.peek().y);
			PairRobot xy = q.poll();
			int depth=0;
			//회전 시작 
			while(true) {
				System.out.println("바라보는 방향 ==> " + dir);
				//4번 회전했을 때, 뒤에 공간 있으면 queue에 넣고 다시 탐색
				if(depth == 4) {
					int[] back = moveBack(xy.first(), xy.second());
					System.out.println("back x: " + back[0] + ", back y: " + back[1]);
					//공간 없으면 그대로 끝
					if(arr[back[0]][back[1]] == 1 || back[0] < 0 || back[0] >= arr.length || back[1] < 0 || back[1] >= arr[0].length) {
						System.out.println("벽에 막힘! 끝! ");
						break;
					}
					q.offer(new PairRobot(back[0], back[1]));
					System.out.println("back해서 다시 탐색! ");
					break;
				}
				
				int[] test = move(xy.first(), xy.second());
				int tempX = test[0];
				int tempY = test[1];
				//이미 청소한 곳이거나 벽인 경우 
				if(visited[tempX][tempY] == true || arr[tempX][tempY] == 1 || tempX < 0 || tempY < 0 || tempX >= arr.length || tempY >= arr[0].length) {
					depth++;
					System.out.println("추가 회전! ");
					continue;
				}		
				 				
				q.offer(new PairRobot(tempX, tempY));
				visited[tempX][tempY] = true;
				System.out.println("한칸 추가! ");
				cnt++;
				break;
			}
		}//q empty
	}
	
	static int[] move(int dx, int dy) {	

		if(dir == 0) {
			dir = 3;
			dy--;
		}else if(dir == 1) {
			dir = 0;
			dx--;
		}else if(dir == 2) {
			dir = 1;
			dy++;
		}else {
			dir = 2;
			dx++;
		}
		
		int[] dxdy = {dx, dy};
		
		return dxdy;
	}
	
	static int[] moveBack(int dx, int dy) {
		//moveBack
		if(dir == 0) {
			dx++;
		}else if(dir == 1) {
			dy--;
		}else if(dir == 2) {
			dx--;
		}else {
			dy++;
		}
	
		int[] dxdy = {dx, dy};
		
		return dxdy;
		
	}
	
}

/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);

        bw.write(cnt + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void clean(int row, int col, int direction) {
        // 1. 현재 위치를 청소한다.
        if (map[row][col] == 0) {
            map[row][col] = 2;
            cnt++;
        }

        // 2. 왼쪽방향부터 차례대로 탐색을 진행한다.
        boolean flag = false;
        int origin = direction;
        for (int i = 0; i < 4; i++) {
            int next_d = (direction + 3) % 4;
            int next_r = row + dr[next_d];
            int next_c = col + dc[next_d];

            if (next_r > 0 && next_c > 0 && next_r < N && next_c < M) {
                if (map[next_r][next_c] == 0) {   // 아직 청소하지 않은 공간이라면
                    clean(next_r, next_c, next_d);
                    flag = true;
                    break;
                }
            }
            direction = (direction + 3) % 4;
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if (!flag) {
            int next_d = (origin + 2) % 4;
            int next_br = row + dr[next_d];
            int next_bc = col + dc[next_d];

            if (next_br > 0 && next_bc > 0 && next_br < N && next_bc < M) {
                if (map[next_br][next_bc] != 1) {
                    clean(next_br, next_bc, origin); // 바라보는 방향 유지한 채 후진
                }
            }
        }
    }
 */
