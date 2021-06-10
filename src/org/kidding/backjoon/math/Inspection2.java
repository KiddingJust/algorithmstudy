package org.kidding.backjoon.math;
    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
//시간초과
public class Inspection2 {
    
	// 2 -> 5, 9  output: 2, 4 // 3 -> 6, 34, 94   // 28 60
	// 2 - > 5, 13 인 경우 output으로 8도 되나? 되겠지. 2, 4, 8
	// 1. 먼저 최소의 수를 구한다
	// 2. 그 수를 그 수보다 작은 수로 나누어주고 나머지를 구한다. 
	// 3. 나머지 수를 루프문을 돌면서 나머지가 같다면 pass해준다
	// 4. pass를 하다가 마지막 index도 같아지면 끗
	// A[i] - A[i-1] 을 모두 구하고 각 수들의 최대공약수를 구하면?
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
    
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<arr[1]; i++){
			int temp = arr[0] % i;
			for(int j=1; j<n; j++) {
				if(arr[j] % i == temp) {
					if(j == n-1) {
						sb.append(i + " ");
					}else {
						continue;
					}
				}else {
					break;
				}
			}
		}

		sb.substring(sb.length()-1, sb.length());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}

//for(int i=1; i<n; i++) {
//if(arr[i] % arr[0] == 0) {
//	if(i == n-1) {
//		sb.append(arr[0] + " ");
//	}else {
//		continue;
//	}
//}else {
//	break;
//}
//}

//for(int i=arr[0]+1; i<arr[1]; i++) {
//for(int j=1; j<n; j++) {
//	if(arr[j] % i == arr[0]) {
//		if(j == n-1) {
//			sb.append(i + " ");
//		}else {
//			continue;
//		}					
//	}else {
//		break;
//	}
//}
//}
