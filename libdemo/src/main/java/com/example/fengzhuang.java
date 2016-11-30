package com.example;

/**
 * 作用：封装
 * 时间：2016/1124
 */
public class fengzhuang {
    public static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("小李子");
        person.setAge(20);
        System.out.print(person.toString());
    }
}
