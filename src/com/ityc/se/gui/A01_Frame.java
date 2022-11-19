package com.ityc.se.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author yuchao
 * @Description 初次认识Frame
 * @Date 2022/11/19 23:35
 **/
public class A01_Frame {

    /**
     * @Author yuchao
     * @Description 创建一个窗口
     * @Date 2022/11/19 23:38
     * @return void
     **/
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 设置窗口大小，单位是像素
        frame.setSize(800, 600);

        // 窗口大小不可变
        frame.setResizable(false);

        frame.setTitle("frame title");

        // 设置窗口可见
        frame.setVisible(true);

        // 关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
