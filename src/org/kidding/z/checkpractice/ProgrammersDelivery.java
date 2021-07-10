package org.kidding.z.checkpractice;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
public class ProgrammersDelivery {

    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int N, int[][] road, int K) {
    	
        int answer = 1;
        
        map.put(1, 0);
        for(int i=2; i<N+1; i++){
            map.put(i, K+1);
        }
        
        int[][] arr = new int[N+1][N+1];
        for(int i=0; i<road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            if(arr[x][y] != 0){
                if(arr[x][y] <= road[i][2]){
                    continue;
                }
            }
            arr[x][y] = arr[y][x] = road[i][2];
        }
        
        for(int i=2; i<N+1; i++){
            if(arr[1][i] != 0){
                map.put(i, arr[1][i]);
                dfs(arr, i, K);
            }
        }
        
        for(int i=2; i<N+1; i++){
            if(map.get(i) <= K){
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int[][] arr, int start, int k){
        for(int i=2; i<arr.length; i++){
            if(i == start){
                continue;
            }
            int d = arr[start][i] + map.get(start);
            if(arr[start][i] != 0 && d<=k){
                if(d<=map.get(i)){
                    map.put(i, d);
                    dfs(arr, i, k);
                }
            }
            
        }
    }
}
