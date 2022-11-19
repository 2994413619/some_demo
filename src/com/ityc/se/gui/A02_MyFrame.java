package com.ityc.se.gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author yuchao
 * @Description �̳�frame���Զ���frame
 * @Date 2022/11/20 0:01
 * @return
 **/
public class A02_MyFrame extends Frame {

    int x = 200, y = 200;

    /**
     * @Author yuchao
     * @Description ��д���췽����new���ڵ�ʱ�����û���������
     * @Date 2022/11/20 0:12 
     **/
    public A02_MyFrame() throws HeadlessException {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("frame title");
        this.setVisible(true);

        this.addKeyListener(new MyKeyListener());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * @Author yuchao
     * @Description ÿ�ε��ö��������������Ȼ���ٻ�
     * @Date 2022/11/20 0:29
     **/
    @Override
    public void paint(Graphics g) {
        // ��һ��������
        g.fillRect(x, y, 50, 50);
        x += 10;
        // ÿ�ε��ã��ı�����
        /*System.out.println(x + "" + y);
        x += 10;
        y += 10;*/
    }

    /**
     * @Author yuchao
     * @Description ���̼����¼�
     * @Date 2022/11/20 0:47
     **/
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            /*x += 20;
            repaint();*/
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released!");
        }
    }


    /**
     * @Author yuchao
     * @Description ���Է���
     * @Date 2022/11/20 0:13
     **/
    public static void main(String[] args) throws InterruptedException {
        A02_MyFrame frame = new A02_MyFrame();
        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }

}
