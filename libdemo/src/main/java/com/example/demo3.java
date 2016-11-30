package com.example;

/**
 * 作用：单继承类
 * 时间：2016/1124
 */
public class demo3 {
    //父类
    public static class Person {
        public void kungfu() {
            System.out.print("我会少林功夫！！\n");
        }

        public void chengxuyuan() {
            System.out.print("我会敲代码！！");
        }
    }

    public static class Son extends Person {

    }

    public static void main(String[] args) {
        Son son = new Son();
        son.kungfu();
        son.chengxuyuan();

    }
}
