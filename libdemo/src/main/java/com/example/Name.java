package com.example;

/**
 * 作用：接口实现多态
 * 时间：2016/1124
 */
public interface Name {
    public String getName();
}

class A implements Name {
    private String name = "class A";

    //实现getName方法
    public String getName() {
        return name;
    }
}

class B implements Name {
    private String name = "class B";

    //实现getName方法
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Name obj = new B();
        System.out.println(obj.getName());

    }
}
