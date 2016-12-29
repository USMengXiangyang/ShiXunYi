package com.example;

import java.util.ArrayList;

//定义观察者接口
interface Observer {
    public void update(String s);
}
//定义主题接口
interface Subject {
    public void regist(Observer observer);//定义注册观察者方法
    public void unRegist(Observer observer);//定义反注册观察者方法
    public void notifyObserver(String s);//通知观察者消息
}

//主题的实现类
class ConcreteSubject implements Subject{
    //定义一个集合，存放注册进来的观察者对象
    private ArrayList< Observer> mList=new ArrayList<Observer>();
    public void regist(Observer observer) {
        mList.add(observer);
    }

    public void unRegist(Observer observer) {
        mList.remove(observer);

    }
    //遍历集合，逐个调用其update方法更新数据
    public void notifyObserver(String s) {
        for(int i=0;i<mList.size();i++)
        {
            mList.get(i).update(s);
        }
    }

}

//1号观察者，实现了观察者类
class ConcreteObserver1 implements Observer {

    /*public ConcreteObserver1(Subject subject) {

        subject.regist(this);
    }*/

    public void update(String s) {
        System.out.println("1993028=="+s);

    }

}
//2号观察者，实现了观察者类
class ConcreteObserver2 implements Observer {

   /* public ConcreteObserver2(Subject subject) {

        subject.regist(this);
    }*/

    public void update(String s) {

        System.out.println("2468==" + s);
    }

}
public class MyClass {
    public static void main(String[] s) {
        Subject subject=new ConcreteSubject();
        //观察者1
        Observer ob1=new ConcreteObserver1();
        //观察者2
        Observer ob2=new ConcreteObserver2();
        //把观察者添加到被观察者里
        subject.regist(ob1);
        subject.regist(ob2);
        subject.notifyObserver("18811373023");
    }

}
