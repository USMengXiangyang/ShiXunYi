package com.example.thread;

import com.example.ThreadTest3;

/**
 * 作用：
 * 时间：2016/1124
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new ThreadTest3()).start();
        new Thread(new ThreadTest3()).start();
        new Thread(new ThreadTest3()).start();
        new Thread(new ThreadTest3()).start();
    }
}
