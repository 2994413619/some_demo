package com.ityc.interview.od3_xingge;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Third {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        //把输入转为int数组
        int[] numbers = Stream.of(numStr.split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();

        //输出的层数
        int count = 0;

        //排序
        Arrays.sort(numbers);

        //求和
        int sum = Arrays.stream(numbers).sum();

        //3、判断是否可以以（最大值）为一层的长度
        if(sum % numbers[numbers.length - 1] == 0) {
            //把最大值去除后，剩下的必须为双数个
            boolean flag = true;//判断一次
            count++;
            for(int j = 0, i = numbers.length - 2; i >= 0 && i >= j; i--) {
                if(numbers[i] == numbers[numbers.length - 1]) {
                    count++;
                    continue;
                } else {
                    //把最大值去除后，剩下的必须为双数个,判断一次
                    if(flag) {
                        if(i % 2 != 1) {
                            count = -1;
                            break;
                        }
                        flag = false;
                    }
                    if(numbers[j] + numbers[i] == numbers[numbers.length - 1] && i != j++) {
                        count++;
                    } else {
                        count = -1;
                        break;
                    }

                }
            }
            if(count != -1) {
                System.out.println(count);
                return;
            }

        }


        count = 0;//设置初始值
        int sum2 = 0;
        //4、判断可否以（最大值 + 最小值）为一层的长度
        if( numbers.length % 2 == 0) {
            sum2 = numbers[0] + numbers[numbers.length - 1];
            for(int i = 0; i < numbers.length / 2; i++) {
                if(numbers[i] + numbers[numbers.length - 1 -i] != sum2) {
                    count = -1;
                    break;
                }
            }
            if(count != -1) {
                count = numbers.length / 2;
            }
        } else {
            count = -1;
        }

        System.out.println(count);

    }
}
