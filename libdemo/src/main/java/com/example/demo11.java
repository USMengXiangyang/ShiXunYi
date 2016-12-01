package com.example;

/**
 * 作用：
 * 时间：2016/1124
 */
public class demo11 {
    public static void main(String[] args) {
        String str = "abcdefabhjlecababcab";
        String str1 = "bc";
        int count = 0;
        int start = 0;
        while (str.indexOf(str1, start) >= 0 && start < str.length()) {
            count++;
            start = str.indexOf(str1, start) + str1.length();
        }
        System.out.println(str1 + "在" + str + "出现的次数为" + count);
    }
}
