package com.ityc.interview.gsc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class First {

    public static String findFirstChar (String input) {
        // write code here
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String temp;

        for(int i = 0; i < input.length(); i++) {
            temp = String.valueOf(input.charAt(i));
            if(map.get(temp) != null) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String ilovestudy = findFirstChar("xxxxx");
        System.out.println(ilovestudy);
    }

}
