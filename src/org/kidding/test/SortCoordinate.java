package org.kidding.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortCoordinate {

    public static void main(String[] args) throws Exception {

    	Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] arr = new int[t][2];	//x,y 좌표 담기
        String[] str = new String[2];
        for (int i = 0; i < t; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
 
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
            	//x좌표 같으면 y좌표로 비
                if (x[0] == y[0]) {
                    return Integer.compare(x[1], y[1]);
                }
                //기본은 x좌표로 비
                return Integer.compare(x[0], y[0]);
            }
 
        });
 
        for (int i = 0; i <t; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
 
    }
 
}
