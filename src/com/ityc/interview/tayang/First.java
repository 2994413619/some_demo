package com.ityc.interview.tayang;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // (n - 1) + (n - 2)
        int a = 1, b = 1;

        int count = 1;//当n = 1的时候
        for(int i = 2; i <= n; i++){
            count = a + b;
            a = b;
            b = count;
        }

        System.out.println(count);
    }
}
