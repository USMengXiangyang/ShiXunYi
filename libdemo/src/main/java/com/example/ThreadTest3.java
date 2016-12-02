package com.example;

/**
 * autour: 孟向阳
 * date: 2016/12/2 10:01
 * update: 2016/12/2
 */
public class ThreadTest3 implements Runnable{
    private static int s=20;
    @Override
    public void run() {
        while(s>0){
            sale();
        }
    }
    public void sale(){
        synchronized (ThreadTest3.class) {
            if(s>0){
                try {

                    s--;
                    System.out.println(Thread.currentThread().getName()+"卖了第"+(20-s)+"张票，剩余："+s+"张.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }else{
                System.out.println("亿售完");
            }
        }
    }

}

