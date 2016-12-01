package com.example;

/**
 * 作用：依赖注入
 * 时间：2016/1201
 */
public class Car {
    private static Fangfa fa;
    public Car() {
        fa = new Fangfa();
    }
    public void abc(){
        fa.zairen();
    }

    public static void main(String[] args) {
       /*Car car = new Car();
        car.abc();*/
        Fangfa faa = new Fangfa();
        faa.zairen();
    }
}
