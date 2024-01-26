package com.ityc.test.test2023;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

public class First {
    public static void main(String[] args) throws URISyntaxException, IOException {
        /*LocalDateTime dateTime = LocalDateTime.of(2017, 8, 01, 0, 0);
        long timeMillis= dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(timeMillis);

        long second = 1501545600000L / 1000;
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);

        List<String> list = new ArrayList<>();
        list.add("frist");
        list.add("second");
        list.add("third");
        List<List<String>> result = new ArrayList<>();
        result.add(list);
        System.out.println(result);*/
        /*BigDecimal v1 = new BigDecimal(2);
        BigDecimal v2 = new BigDecimal(1);
        System.out.println(v1.compareTo(v2) > 0);*/
        /*String str = "sss";
        System.out.println(str.hashCode());
        System.out.println(str.hashCode() >>> 16);
        System.out.println(11 & 8);
        Desktop.getDesktop().browse(new URI("http://www.baidu.com"));*/

        /*NumberFormat numberFormat = NumberFormat.getInstance();
        String str = null;
        System.out.println(numberFormat.format(str));*/

        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO) == 0);


    }


}
