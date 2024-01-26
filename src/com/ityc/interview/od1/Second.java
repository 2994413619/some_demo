package com.ityc.interview.od1;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        //表示第n - 1个数的值。默认为第0个
        String pre = "1";

        String resultStr = "11";
        char temp;
        int count;

        //计算n次
        for(int i = 1; i < n; i++){

            pre = resultStr;
            resultStr = "";
            temp = pre.charAt(0);
            count = 1;//初始化为1，表示开始为1个temp

            //计算
            for(int j = 1; j < pre.length(); j++){
                if(temp == pre.charAt(j)){
                    count++;
                } else {
                  //记录前一个字符
                  resultStr =resultStr + count + temp;
                  //记录现在新出现的字符
                  temp = pre.charAt(j);
                  count = 1;
                }
            }
            resultStr = resultStr + count + temp;

        }
        System.out.println(resultStr);

    }
}
