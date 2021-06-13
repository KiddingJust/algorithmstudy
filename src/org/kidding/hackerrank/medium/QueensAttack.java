package org.kidding.hackerrank.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttack {

	//n: number of rows and columns
	//k: number of obstacles
	//r_q: queens position(row)
	//c_q: queens position(column)
	//int obstacles[k][2]: obstacles. input 시 k 숫자만큼 배열. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[][] obstacle = new int[n][n];
		int r_q = Integer.parseInt(st.nextToken());
		int c_q = Integer.parseInt(st.nextToken());
		r_q = n-r_q;
		c_q = c_q-1;
		
        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        int dt = r_q;	//위
        int db = n-r_q-1; //아래
        int dl = c_q;	//왼
        int dr = n-c_q-1; //오른
        //위왼
        int dtl = 0;
        //위오
        //아래왼
        //아래오
        
        for(int i=0; i<obstacles.size(); i++) {
			int r = obstacles.get(i).get(0);
			int c = obstacles.get(i).get(1);
			obstacle[n-r][c-1] = 1;
        }
        
        //그냥 뺄셈으로 해야겠다. 예를 들어, 왼쪽의 경우 r_q-r, c_c-qr 이런 식으로
        //그럼 가장 가까운 걸 찾아야해. 
        //하나하나 찾아가면서 answer++하는 게 아니라 뺼셈으로 한번에 계산.
        
		
		//---- SETTING 
		
        int answer = 0;

		
        //그냥 탐색을 하자 
        //횡 이동
        //왼쪽 이동
        for(int i=c_q-1; i>=0; i--) {
        	if(obstacle[r_q][i] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);
        //오른쪽 이동
        for(int i=c_q+1; i<n; i++) {
        	if(obstacle[r_q][i] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        //위쪽 이동
        for(int i=r_q-1; i>=0; i--) {
        	if(obstacle[i][c_q] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        //아래쪽 이동
        for(int i=r_q+1; i<n; i++) {
        	if(obstacle[i][c_q] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        //왼위 이동
        for(int i=r_q-1, j=c_q-1; i>=0 && j>=0; i--, j--) {
        	if(obstacle[i][j] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        //오위 이동 
        for(int i=r_q-1, j=c_q+1; i>=0 && j<n; i--, j++) {
        	if(obstacle[i][j] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        //왼아래 이동
        for(int i=r_q+1, j=c_q-1; i<n && j>=0; i++, j--) {
        	if(obstacle[i][j] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        //오아래 이동
        for(int i=r_q+1, j=c_q+1; i<n && j<n; i++, j++) {
        	if(obstacle[i][j] == 1) {
        		break;
        	}
        	answer++;
        }
        System.out.println("answer: " + answer);

        

		//전체 탐색. 조건에 걸리는 건 대각선일 때와 한줄일 때
		//obstacle에 속한 경우는 X. 
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(i == r_q || j == c_q || Math.abs(i-r_q) == Math.abs(j-c_q)) {
//					if(obstacle[i][j] != 1) {
//						System.out.println("i: " + i + ", j: " + j);
//						answer++;
//					}
//				}
//			}
//		}
		
		System.out.println(answer);
	}
}
