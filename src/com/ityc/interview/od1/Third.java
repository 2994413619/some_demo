package com.ityc.interview.od1;

import java.util.Scanner;

public class Third {

    public static int[] arr = {0,1,2,3,4,5,6};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i = 0; i < str.length(); i++){
            if('L' == str.charAt(i)){
                changeL();
            } else if('R' == str.charAt(i)){
                changeR();
            } else if('F' == str.charAt(i)){
                changeF();
            } else if('B' == str.charAt(i)){
                changeB();
            } else if('A' == str.charAt(i)){
                changeA();
            } else if('C' == str.charAt(i)){
                changeC();
            }
        }

        //输出结果
        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i]);
        }

    }

    //L:1 = 5; 5 = 2; 2 = 6; 6 = 1;
    public static void changeL(){
        int temp = arr[1];
        arr[1] = arr[5];
        arr[5] = arr[2];
        arr[2] = arr[6];
        arr[6] = temp;
    }

    //R:6 = 2; 2 = 5; 5 = 1; 1 = 6;
    public static void changeR(){
        int temp = arr[6];
        arr[6] = arr[2];
        arr[2] = arr[5];
        arr[5] = arr[1];
        arr[1] = temp;
    }

    //F:3 = 5; 5 = 4; 4 = 6; 6 = 3;
    public static void changeF(){
        int temp = arr[3];
        arr[3] = arr[5];
        arr[5] = arr[4];
        arr[4] = arr[6];
        arr[6] = temp;
    }

    //B:6 = 4; 4 = 5; 5 = 3; 3 = 6;
    public static void changeB(){
        int temp = arr[6];
        arr[6] = arr[4];
        arr[4] = arr[5];
        arr[5] = arr[3];
        arr[3] = temp;
    }

    //A:1 = 4; 4 = 2; 2 = 3; 3 = 1;
    public static void changeA(){
        int temp = arr[1];
        arr[1] = arr[4];
        arr[4] = arr[2];
        arr[2] = arr[3];
        arr[3] = temp;
    }

    //C:3 = 2;2 = 4; 4 = 1; 1 = 3;
    public static void changeC(){
        int temp = arr[3];
        arr[3] = arr[2];
        arr[2] = arr[4];
        arr[4] = arr[1];
        arr[1] = temp;
    }

}
