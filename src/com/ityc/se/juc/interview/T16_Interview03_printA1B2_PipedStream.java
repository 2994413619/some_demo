package com.ityc.se.juc.interview;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 *              PipedStream效率很低，仅了解
 * @Date 2021/12/21 16:02
 **/
public class T16_Interview03_printA1B2_PipedStream {

    public static void main(String[] args) throws Exception {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        PipedInputStream input1 = new PipedInputStream();
        PipedInputStream input2 = new PipedInputStream();
        PipedOutputStream output1 = new PipedOutputStream();
        PipedOutputStream output2 = new PipedOutputStream();

        input1.connect(output2);
        input2.connect(output1);

        String msg = "Your Turn";



        new Thread(() -> {

            byte[] buffer = new byte[9];

            try {
                for(char c : aI) {
                    input1.read(buffer);

                    if(new String(buffer).equals(msg)) {
                        System.out.print(c);
                    }

                    output1.write(msg.getBytes());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }, "t1").start();

        new Thread(() -> {

            byte[] buffer = new byte[9];

            try {
                for(char c : aC) {

                    System.out.print(c);

                    output2.write(msg.getBytes());

                    input2.read(buffer);

                    if(new String(buffer).equals(msg)) {
                        continue;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }, "t2").start();
    }

}
