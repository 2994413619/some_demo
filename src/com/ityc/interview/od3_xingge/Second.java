package com.ityc.interview.od3_xingge;

import java.util.Scanner;
import java.util.stream.Stream;

public class Second {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        //把输入转为int数组
        int[] numbers = Stream.of(numStr.split(",")).mapToInt(n -> Integer.parseInt(n)).toArray();

        int result = 0;
        int temp;//临时面积
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j= i + 1; j < numbers.length; j++) {
                temp = (j - i) * (numbers[j] < numbers[i] ? numbers[j] : numbers[i]);
                result = result > temp ? result : temp;
            }
        }

        System.out.println(result);
    }
}
