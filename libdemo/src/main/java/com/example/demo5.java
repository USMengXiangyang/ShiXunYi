package com.example;

/**
 * 作用：无重复三位数
 * 时间：2016/1130
 */
public class demo5 {
    public static void main(String[] args) {
        //计数器变量
        int count = 0;

  /*
   * 利用三重循环组合数字的百、十、个位
   */

        //生成百位
        for (int i = 1; i <= 4; i++) {
            //生成十位
            for (int j = 1; j <= 4; j++) {
                //生成个位
                for (int k = 1; k <= 4; k++) {

                    //确保i、j、k三位互不相同
                    if (i != j && j != k && i != k) {

                        //计数器累加
                        ++count;
                        //控制台输出当前组合出的三位数
                        System.out.println("第" + count + "种组合方式：" + i + "" + j + "" + k);
                    }
                }
            }
        }

        //控制台输出统计信息
        System.out.println(" 共计" + count + "种三位数组合方式。");
    }
}
