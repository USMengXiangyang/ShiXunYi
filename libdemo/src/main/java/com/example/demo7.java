package com.example;

/**
 * 作用：回文数
 * 时间：2016/1130
 */
public class demo7 {
    public static boolean isPalindrome(int n){
        String num = Integer.toString(n);
        int len = num.length();
        int half = len/2;
        int is = 1;
        for (int i = 0; i < half; i++){
            if(num.charAt(i) != num.charAt(len-1-i)){
                is = 0;
                break;
            }
        }
        if(is == 1){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        for (int i = 10000; i <= 99999; i++) {

            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }
}
