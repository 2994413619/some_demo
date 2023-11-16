package com.ityc.arithmetic.leetcode.leetcode0420;

import java.util.Arrays;

/**
 * 根据身高重建队列 ac:100%
 * @author yuchao
 * @Date 2023/11/16 17:37
 **/
public class LeetCode406_Queue_Reconstruction_by_Height {

    public static int[][] reconstructQueue(int[][] people) {

        // 按第一个元素降序，第二个元素升序排列；排序之后，每个people前面所有人都比自己高。
        Arrays.sort(people, (arr1, arr2) -> {
            if (arr1[0] != arr2[0]) {
                return  arr2[0] - arr1[0];
            } else {
                return arr1[1] - arr2[1];
            }
        });

        // 插入排序，把第二个元素当做坐标
        int[] temp;
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] != i) {
                temp = people[i];;
                // 元素后移
                for (int j = i; j > temp[1]; j--) {
                    people[j] = people[j - 1];
                }

                people[temp[1]] = temp;
            }
        }

        return people;

    }

    // test
    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ints = reconstructQueue(people);
        System.out.println(String.valueOf(ints));
    }

}
