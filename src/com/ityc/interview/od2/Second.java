package com.ityc.interview.od2;

import java.util.ArrayList;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int maxLength = 0;
        char temp;

        ArrayList<Character> stack = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if(isStart(temp)) {
                stack.add(temp);
                maxLength = stack.size() > maxLength ? stack.size() : maxLength;
            } else {
                //栈中为空，且要压栈的为右半边，不符合条件
                if(stack.size() == 0) {
                    maxLength = 0;
                    break;
                } else {
                    Character temp2 = stack.get(stack.size() - 1);
                    if(isOk(temp2, temp)) {//左右配对，弹栈
                        stack.remove(stack.size() - 1);
                    } else {// 不配对，不符合条件
                        maxLength = 0;
                        break;
                    }
                }
            }
        }

        if(stack.size() != 0) {
            maxLength = 0;
        }

        //输出最大嵌套深度
        System.out.println(maxLength);

    }

    /**
     * 判断是否为其实字符
     * @param c
     * @return
     */
    public static boolean isStart(char c) {
        if(c == '(' || c == '{' || c == '[') {
            return true;
        }
        return false;
    }

    /**
     * 判断两个符号是否配对
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isOk(char c1, char c2) {

        if((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
            return true;
        }

        return false;
    }

}
