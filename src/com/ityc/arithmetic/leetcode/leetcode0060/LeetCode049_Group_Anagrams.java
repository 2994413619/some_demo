package com.ityc.arithmetic.leetcode.leetcode0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ac:100% ��ĸ��λ�ʷ���
 * @author yuchao
 * @Date 2023/11/4 16:13
 **/
public class LeetCode049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        loopOut:for(String str : strs) {
            // �Ա�result��ÿ��List.get(0)�Ƿ���str����ĸ��λ��
            // ��
            for(List<String> list : result) {
                if(isSameChar(list.get(0), str)) {
                    list.add(str);
                    continue loopOut;
                }
            }

            // ��
            List<String> temp = new ArrayList<>();
            temp.add(str);
            result.add(temp);
        }
        return result;
    }

    /**
     * ���߷������ж������ַ����Ƿ�Ϊ��ĸ��λ��
     * @author yuchao
     * @Date 2023/11/4 16:41
     * @param str1
     * @param str2
     * @return boolean
     **/
    public boolean isSameChar(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        str1 = sorted(str1);
        str2 = sorted(str2);
        return str1.equals(str2);
    }

    /**
     * ���߷��������ַ�������ASCII������
     * @author yuchao
     * @Date 2023/11/4 16:59
     * @param str �����ַ��������磺ddfead
     * @return �������ַ��������磺adddef
     **/
    public String sorted(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    /**
     * ���Է���
     * @author yuchao
     * @Date 2023/11/4 17:02
     **/
    public static void main(String[] args) {
        LeetCode049_Group_Anagrams instance = new LeetCode049_Group_Anagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = instance.groupAnagrams(strs);
        System.out.println(lists.toString());
    }

}
