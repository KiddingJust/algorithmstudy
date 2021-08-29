package org.kidding.programmers.leveltest;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/1829
// 1 1 1 0
// 1 2 2 0
// 1 0 0 1
// 0 0 0 1
// 0 0 0 3
// 0 0 0 3
public class L2_ColoringBook {

    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int m = 6;
    static int n = 4;
    static int[][] picture = 
    		{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
	public static void main(String[] args) {


        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    bfs(i, j, m, n, picture[i][j], picture);
                    numberOfArea++;
                }
            }
        }        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
    }
    
    static void bfs(int startX, int startY, int m, int n, int num, int[][] picture){
        
        int size = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY));
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()){
            Pair xy = queue.poll();
            int x = xy.x;
            int y = xy.y;
            
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx>=0&&ny>=0&&nx<m&&ny<n){
                    if(!visited[nx][ny] && picture[nx][ny] == num){
                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                        size++;
                    }
                }
            }
            
            
        }
        
        if(size >= maxSizeOfOneArea){
        	maxSizeOfOneArea = size;
        }
        
    }
}

class Pair{
    int x;
    int y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

