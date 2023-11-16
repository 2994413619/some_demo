package com.ityc.arithmetic.leetcode.leetcode0420;

import java.util.Arrays;

/**
 * ��������ؽ����� ac:100%
 * @author yuchao
 * @Date 2023/11/16 17:37
 **/
public class LeetCode406_Queue_Reconstruction_by_Height {

    public static int[][] reconstructQueue(int[][] people) {

        // ����һ��Ԫ�ؽ��򣬵ڶ���Ԫ���������У�����֮��ÿ��peopleǰ�������˶����Լ��ߡ�
        Arrays.sort(people, (arr1, arr2) -> {
            if (arr1[0] != arr2[0]) {
                return  arr2[0] - arr1[0];
            } else {
                return arr1[1] - arr2[1];
            }
        });

        // �������򣬰ѵڶ���Ԫ�ص�������
        int[] temp;
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] != i) {
                temp = people[i];;
                // Ԫ�غ���
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
