package com.ityc.se.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author yuchao
 * @Description ������ʶFrame
 * @Date 2022/11/19 23:35
 **/
public class A01_Frame {

    /**
     * @Author yuchao
     * @Description ����һ������
     * @Date 2022/11/19 23:38
     * @return void
     **/
    public static void main(String[] args) {
        Frame frame = new Frame();

        // ���ô��ڴ�С����λ������
        frame.setSize(800, 600);

        // ���ڴ�С���ɱ�
        frame.setResizable(false);

        frame.setTitle("frame title");

        // ���ô��ڿɼ�
        frame.setVisible(true);

        // �رմ���
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
