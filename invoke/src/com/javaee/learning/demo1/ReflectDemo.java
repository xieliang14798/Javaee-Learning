package com.javaee.learning.demo1;


public class ReflectDemo {
    public static void main(String[] args) {
        Person person = new Person();
        //对象获取
        Class c1 = person.getClass();
        System.out.println(c1);

        //类名获取
        Class c2 = Person.class;
        System.out.println(c2);

        //Class类的静态方法获取 forName(字符串的类名)包名.类名
        try {
            Class c3 = Class.forName("com.javaee.learning.demo1.Person");
            System.out.println(c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
