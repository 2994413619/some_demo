package com.ityc.interview.od4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author yuchao
 * @Description
 * @Date 2026/05
 **/
public class Second {

    public static void main(String[] args) {
        Second second = new Second();
        int[][] ints;
        int[][] arras = {{1,5},{2,3},{3,7},{4,6},{4,5}};
        ints = second.processPackets(5,3,arras);

//        int[][] arras = {{1,1},{2,2},{3,3},{4,4}};
//        ints = second.processPackets(4,3,arras);

//        int[][] arras = {{4,4},{3,3},{2,2},{1,1}};
//        ints = second.processPackets(4,3,arras);

        System.out.println(Arrays.deepToString(ints));

    }


    public int[][] processPackets (int n, int k, int[][] packets) {
        int[][] result = new int[n][];
        if (n < k) {
            return result;
        }
        // 记录上一个窗口所有符合条件的id; -1 表示没有
        int[] idPris= new int[k];

        // 临时结果
        ArrayList<int[]> ids = new ArrayList<>();

        int[] idsTemp = new int[k]; // 0表示无

        // 滑动窗口
        for (int i = 0; i < n - k + 1; i++) {
            ArrayList<Integer> idsTempArr = new ArrayList<>();


            // 初始化第一个
            if (i == 0) {
                for (int j = i; j < k + i; j++) {
                    for (int x = j + 1; x < k; x++) {
                        if (packets[x][1] >packets[j][1]) {
                            idsTemp[j] = packets[x][0]; // 记录id
                            idsTempArr.add(packets[x][0]); //记录结果集
                            break;
                        }
                    }
                }
            } else {
                for (int j = i; j < k + i; j++) {
                    // 上一次遍历有的话直接获取
                    if(j != k + i - 1) { // 不是最后一个
                        if (idsTemp[j - i + 1] != 0) {
                            idsTemp[j - i] = idsTemp[j - i + 1]; // 记录id
                            idsTempArr.add(idsTemp[j - i + 1]); //记录结果集
                            continue;
                        } else {
                            if (packets[i + k - 1][1] > packets[j][1]) {
                                idsTemp[j - i] = packets[i + k - 1][0]; // 记录id
                                idsTempArr.add(packets[i + k - 1][0]); //记录结果集
                                continue;
                            }
                        }
//                        idsTemp[j - i] = 0;
                    }

//                    for (int x = j + 1; x < k + j && x < n; x++) {
//                        if (packets[x][1] >packets[j][1]) {
//                            idsTemp[j - i] = idsTemp[j - i + 1]; // 记录id
//                            idsTempArr.add(packets[x][0]); //记录结果集
//                            break;
//                        }
//                    }
                }
            }

            // 窗口数组
            if(!idsTempArr.isEmpty()){
                int[] temp= new int[idsTempArr.size()];
                for (int j = 0; j < idsTempArr.size(); j++) {
                    temp[j] = idsTempArr.get(j);
                }
                ids.add(temp);
            }


        }

        //转换结果
        int[][] ints =  new int[1][];
        if (!ids.isEmpty()) {
            ints = new int[ids.size()][];
            for (int i = 0; i < ids.size(); i++) {
                ints[i] = ids.get(i);
            }
        }
        return ints;

    }

}
