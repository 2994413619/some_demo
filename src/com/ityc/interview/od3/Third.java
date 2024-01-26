package com.ityc.interview.od3;

import java.util.*;

public class Third {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        List<Set> wordList = new ArrayList<Set>(); // 相似词集合
        ArrayList<Set<Integer>> lengthList = new ArrayList<>();// 相似词长度

        String temp;
        boolean hasXin = false;
        ArrayList<String> xinList = new ArrayList<>();

        while (in.hasNextLine()) {
            temp = in.nextLine();
            if (temp.indexOf("***") >= 0) {
                hasXin = true;
                xinList.add(temp);
            } else {
                String[] strings = temp.split(" ");
                // 相似度判断
                Integer index = isLike(wordList, strings);
                if(index == null) {
                    Set<Integer> lengthSet = new HashSet<>(); // 相似词长度
                    Set<String> strSet = new HashSet<>(); // 相似词
                    for (String strTemp : strings) {
                        strSet.add(strTemp);
                        lengthSet.add(strTemp.length());
                    }
                    wordList.add(strSet);
                    lengthList.add(lengthSet);
                } else {
                    Set<Integer> lengthSet = lengthList.get(index);
                    Set<String> strSet = wordList.get(index);
                    for (String strTemp : strings) {
                        strSet.add(strTemp);
                        lengthSet.add(strTemp.length());
                    }
                }
            }
        }

        //---------处理--------//
        String result = "True";
        List<String> resultWords = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while(index1 < str1.length() && index2 < str2.length()) {
            if(str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
                index2++;
                continue;
            } else {
                // 相似判断
                for(int i = 0; i < wordList.size(); i++) {
                    Set wordSet = wordList.get(i);
                    Set<Integer> lengthSet = lengthList.get(i);
                    boolean isLike1 = false, isLike2 = false;
                    for (Integer length : lengthSet) {

                    }

                    if(!isLike1 || !isLike2) {
                        result = "False";
                    }
                }
            }
        }
        System.out.println("True");


    }


    public static Integer isLike(List<Set> wordList, String[] strings) {
        for(String str : strings) {
            for (int i = 0; i < wordList.size(); i++) {
                Set set = wordList.get(i);
                if(set.contains(set)) {
                    return i;
                }
            }
        }
        return null;
    }

}
