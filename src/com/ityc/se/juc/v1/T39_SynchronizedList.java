package com.ityc.se.juc.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author yuchao
 * @Description
 * @Date 2021/12/21 10:16
 **/
public class T39_SynchronizedList {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }

}
