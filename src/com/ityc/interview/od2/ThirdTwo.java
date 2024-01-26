package com.ityc.interview.od2;

import java.util.Scanner;

public class ThirdTwo {

    public static int max = 0;

    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int temp;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                temp = find(arr, i, j);
                max = max > temp ? max : temp;
            }
        }
        System.out.println(max);

    }

    /**
     * arr[i - 1][j]
     * arr[i + 1][j]
     * arr[i][j - 1]
     * arr[i][j + 1]
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int find(int[][] arr,int i, int j) {
        if(arr[i][j] == 0) {
            return 0;
        }
        int count = arr[i][j];
        arr[i][j] = 0;

        if(i - 1 >= 0) {
            count += find(arr,i - 1, j);
        }

        if(i + 1 < n) {
            count += find(arr,i + 1, j);
        }

        if(j - 1 >= 0) {
            count += find(arr, i, j - 1);
        }

        if(j + 1 < m) {
            count += find(arr, i, j + 1);
        }


        return count;
    }

}
