package com.example;

import java.io.File;
import java.util.Scanner;
/**
 * 作用：控制台输入，判断是否是文件，是，遍历；否，提示；
 * 时间：2016/1129
 */

public class MyClass {
    public static void main(String[] args) {
        File dir = getDir();
        int num = 1;
        //输出输入的文件夹名字
        System.out.println(dir.getName());
        print(dir, num);
    }

    public static File getDir() {
        //1、新建键盘录入对象，并录入字符串
        Scanner sc = new Scanner(System.in);
        //2、判断是否是文件夹路径（调用getDir方法）
        while (true) {
            String line = sc.nextLine();
            File file = new File(line);
            if (!file.exists()) {
                System.out.println("输入路径错误，请重新输入：");
            } else if (file.isFile()) {
                System.out.println("输入的路径为文件路径，请重新输入：");
            } else if (file.isDirectory()) {
                return file;
            }
        }
    }

    public static void print(File dir, int num) {

        //3、创建文件对象数组并使用list方法获取
        File[] files = dir.listFiles();
        for (File file : files) {
            //4、遍历数组，判断是否是文件，是文件则输出文件名，是文件夹则输出文件夹名并递归
            if (file.isFile()) {
                for (int i = 0; i < num; i++) {
                    System.out.print(" ");
                }
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println();
                for (int i = 0; i < num; i++) {
                    System.out.print(" ");
                }
                System.out.println(file.getName());
                num++;
                print(file, num);
            }
        }
    }
}
