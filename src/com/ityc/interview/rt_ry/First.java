package com.ityc.interview.rt_ry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer temp;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            temp = sc.nextInt();
            if (map.get(temp) == null) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                System.out.println(entry.getKey());
            }
        }

    }

}
