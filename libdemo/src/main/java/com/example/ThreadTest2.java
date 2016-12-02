package com.example;

/**
 * 作用：
 * 时间：2016/1124
 */
public class ThreadTest2 extends Thread {
    private String name;

    public ThreadTest2(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        ThreadTest2 mTh1 = new ThreadTest2("A");
        ThreadTest2 mTh2 = new ThreadTest2("B");
        mTh1.start();
        mTh2.start();

    }


}
