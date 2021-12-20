package com.ityc.se.juc.v1;

import java.lang.ref.WeakReference;

/**
 * @Author yuchao
 * @Description �����ã��⵽gc�ͻ����
 * @Date 2021/12/20 14:12
 **/
public class T27_Hello_WeakReference {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public static void main(String[] args) {
        WeakReference<T27_Hello_WeakReference> m = new WeakReference<>(new T27_Hello_WeakReference());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());


        ThreadLocal<T27_Hello_WeakReference> tl = new ThreadLocal<>();
        tl.set(new T27_Hello_WeakReference());
        tl.remove();//��ʹ��һ��Ҫremove(),��Ȼ���ڴ�й¶��������ֻ�ܽ��key,���ܽ��value

    }
}
