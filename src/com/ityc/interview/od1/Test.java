package com.ityc.interview.od1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //输入
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        //排序
        Arrays.sort(arr);

        //结果
        HashSet<Integer> set = new HashSet<Integer>();

        set.add(arr[0]);
        first : for(int i = 1; i < n; i++){
            for(int temp : set){
                if(arr[i] % temp == 0) {
                    continue first;
                }
            }
            set.add(arr[i]);
        }

        System.out.println(set.size());

    }
}
