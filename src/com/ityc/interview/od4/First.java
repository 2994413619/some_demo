package com.ityc.interview.od4;

/**
 * @Author yuchao
 * @Description
 * @Date 2026/05
 **/
public class First {

    //a97;z122;A65;Z90;0-48;9-57

    public static void main(String[] args) {
        /*int aa = 'a';
        int bb = 'z';
        int AA = 'A';
        int ZZ = 'Z';
        int zero = '0';
        int nine = '9';
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(AA);
        System.out.println(ZZ);
        System.out.println(zero);
        System.out.println(nine);
        System.out.println('c'>97);*/

        String inputStr = "aaa2222bb66";
        int inputDivisor = 2;

        First first = new First();
        int i = first.GetMaxDividend(inputStr, inputDivisor);
        System.out.println(i);
    }

    public int GetMaxDividend (String inputStr, int inputDivisor) {
        // 入参校验
        if(inputStr == null || inputStr.length() == 0 || inputStr.length() > 10000
                || inputDivisor < 1 || inputDivisor > 100) {
            return -1;
        }

        int maxNum = -1;// 返回值
        int satrtIndex = 0,endIndex = 0; // 数字字符串下标
        boolean flag = false; // 状态-true表示是数字
        int temp = 0;

        // 包含不合规字符
        for(int i = 0; i < inputStr.length(); i++) {
            temp = judge(inputStr.charAt(i));
            if(temp < 0) {
                return -1;
            }

            // 上一个是字符，这一个也是字符
            if (!flag && temp == 0) {
                continue;
            }
            // 第一个数字 记录下第一个数字下标
            if (!flag && temp == 1) {
                satrtIndex = i; // 记录前下标
                flag = true;
                if(i == inputStr.length() - 1) { // 遍历到头了
                    maxNum = getMaxNum(inputStr, satrtIndex, inputStr.length(), maxNum, inputDivisor);
                }

                continue;
            }
            // 不是第一个数字
            if(flag && temp == 1) {
                if(i == inputStr.length() - 1) { // 遍历到头了
                    maxNum = getMaxNum(inputStr, satrtIndex, inputStr.length(), maxNum, inputDivisor);
                }
                continue;
            }
            // 上一个是数字，这一个是字符
            if(flag && temp == 0) {
                endIndex = i; // 记录后下标
                flag = false;
                if(i == inputStr.length() - 1) { // 遍历到头了
                    maxNum = getMaxNum(inputStr, satrtIndex, inputStr.length(), maxNum, inputDivisor);
                }
                maxNum = getMaxNum(inputStr, satrtIndex, endIndex, maxNum, inputDivisor);

            }


        }

        //数字不合法
        if (maxNum == Integer.MAX_VALUE) {
            return -1;
        }

        return maxNum;
    }

    public int getMaxNum(String inputStr, int satrtIndex, int endIndex, int maxNum, int inputDivisor) {
        Integer value = Integer.valueOf(inputStr.substring(satrtIndex, endIndex));

        // 判断数字是否合法
        if (value > 999) {
            return Integer.MAX_VALUE;
        }

        if (value % inputDivisor != 0) {
            return maxNum;
        }
        return maxNum > value ? maxNum : value;
    }

    // 判断字符是否合规:0-字符；1-数字；-1-不合规
    public int judge(char temp) {
        if(temp >= 'a' && temp <= 'z') {
            return 0;
        }
        if(temp >= 'A' && temp <= 'Z') {
            return 0;
        }
        if(temp >= '0' && temp <= '9') {
            return 1;
        }
        return -1;
    }

}
