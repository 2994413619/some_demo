package com.ityc.test.test2023.test2024;

import java.time.LocalDate;

/**
 *
 * @author yuchao
 * @date 2024/3/5 19:29
 **/
public class Third {

    public static void main(String[] args) {
        String date1 = "2023-08-01";
        Integer a = Integer.valueOf(date1.split("-")[1]);
        System.out.println(a);

        System.out.println(LocalDate.now().getMonthValue());

    }

}
