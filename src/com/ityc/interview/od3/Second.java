package com.ityc.interview.od3;

import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();// 换行符
        String result = "";
        
        for (int x = 0; x < n; x++) {
            String str = in.nextLine();
            String[] kq = str.split(" ");
            String isGet = judge(kq);
            if(result.length() == 0) {
                result = isGet;
            } else {
                result += " " + isGet;
            }
        }
        
        
        System.out.println(result);
    }
    
    public static String judge(String[] kq) {
        // 计算缺勤数;计算连续是否有连续迟到、早退;
        int count = 0;
        boolean flag = true;// 前一天不是迟到、早退
        for (int i = 0; i < kq.length; i++) {
            if ("absent".equals(kq[i])) {
                count++;
            }
            if (count >= 2) {
                return "false";
            }

            if("late".equals(kq[i]) || "leaveearly".equals(kq[i])) {
                if (!flag) {
                    return "false";
                }
                flag = false;
            } else {
                flag = true;
            }

        }

        // 计算连续7天
        count = 0;
        // 前面7天总 迟到早退数
        for(int i = 0; i < 7 && i < kq.length; i++) {
            if ("late".equals(kq[i]) || "leaveearly".equals(kq[i]) || "absent".equals(kq[i])) {
                count++;
            }
            if (count >= 4) {
                return "false";
            }
        }
        if (kq.length > 7) {
            for (int i = 7; i < kq.length; i++) {
                if ("late".equals(kq[i - 7]) || "leaveearly".equals(kq[i - 7]) || "absent".equals(kq[i - 7])) {
                    count--;
                }
                if ("late".equals(kq[i]) || "leaveearly".equals(kq[i]) || "absent".equals(kq[i])) {
                    count++;
                }
                if (count >= 4) {
                    return "false";
                }
            }
        }

        return "true";
    }

}
