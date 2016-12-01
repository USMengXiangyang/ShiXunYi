package com.example;

/**
 * 作用：杨辉三角
 * 时间：2016/1130
 */
public class demo8 {
   /* public static void main(String[] args) {
        int r = 10;

        int a[][] = new int[r + 1][];
        for (int i = 0; i <= r; i++) {
            a[i] = new int[i + 1];
        }
        yanghui(a, r);
    }
    static void yanghui(int a[][], int r) {
        for (int i = 0; i <= r; i++)
            for (int j = 0; j <= a[i].length - 1; j++) {
                if (i == 0 || j == 0 || j == a[i].length - 1)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= a[i].length - 1; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }*/
   public static void main(String[] args) {
       int a[][]=new int[5][5];
       for (int i=0;i<a.length ;i++ )
       {
           for (int j=0;j<a[i].length ;j++ )
           {
               if (j==0||i==j)
               {
                   a[i][j]=1;
               }
               else{
                   if (i>j)
                   {
                       a[i][j]=a[i-1][j]+a[i-1][j-1];
                   }
               }
           }
       }
       for (int i=0;i<a.length ;i++ )
       {
           for (int j=0;j<a[i].length ;j++ )
           {
               if (i>=j)
               {
                   System.out.print(a[i][j]+"\t");
               }
           }
           System.out.println();
       }
   }


}
