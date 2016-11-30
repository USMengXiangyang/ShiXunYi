package com.example;

/**
 * 作用：1加到20阶乘
 * 时间：2016/1130
 */
public class demo6 {
    public static void main(String[] args) {
        int sum=0;
        for(int i=1;i<=20;i++)//用于遍历1~20
        {   int temp=1;
            for(int j=1;j<=i;j++)//用于求i!;
            {
                temp*=j;
            }
            sum+=temp;

        }
        System.out.println(sum);
    }
}
