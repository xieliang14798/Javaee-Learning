package com.javaee.learning.demo1;

public class Person {
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public void eat() {

        System.out.println("人吃饭");
    }

    public void sleep(String s, int a, double d) {

        System.out.println(s + "在睡觉，从" + a + "点开始，一共" + d + "个小时");
    }

    private void playGame() {
        System.out.println("人在打游戏");
    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

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

}
