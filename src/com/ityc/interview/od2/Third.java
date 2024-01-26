package com.ityc.interview.od2;

import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        //水平相加，并反推
        for(int i = 0; i < n; i++) {
            //水平相加
            for(int j = 1; j < m; j++) {
                if(arr[i][j] != 0) {
                    arr[i][j] += arr[i][j - 1];
                }
            }
            //反推
            for(int j = m - 1; j > 0; j--) {
                if(arr[i][j] != 0 && arr[i][j - 1] != 0) {
                    arr[i][j - 1] = arr[i][j];
                }
            }
        }


        //垂直相加并反推
        for(int j = 0; j < m; j++) {

            //垂直相加
            for(int i = 1; i < n; i++) {
                if(arr[i][j] != 0) {
                    arr[i][j] += arr[i - 1][j];
                }
            }

            //反推
            for(int i = n - 1; i > 0; i--) {
                if(arr[i][j] != 0 && arr[i - 1][j] != 0) {
                    arr[i - 1][j] = arr[i][j];
                }
            }

        }


        //取最大值
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                max = max > arr[i][j] ? max : arr[i][j];
            }
        }

        System.out.println(max);

    }

}
