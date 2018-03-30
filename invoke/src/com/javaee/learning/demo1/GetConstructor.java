package com.javaee.learning.demo1;

import java.lang.reflect.Constructor;

public class GetConstructor {
    private static String packageName = "com.javaee.learning.demo1.Person";

    public static void main(String[] args) throws Exception {
        method_01();
        method_02();
        method_03();
        method_04();
    }

    /*
     * 反射获取构造方法并运行的快捷方法
     * 有前提:
     *   被反射的类,必须具有空参数构造方法
     *   构造方法权限必须public
     */
    private static void method_01() throws Exception {
        Class c = Class.forName(packageName);
        Object object = c.newInstance();
        System.out.println("---------  method_01:" + object.toString() + "  ---------");
    }

    /*反射获取空参数的构造方法*/
    private static void method_02() throws Exception {
        Class c = Class.forName(packageName);
        Constructor constructor = c.getConstructor();
        Object object = constructor.newInstance();
        System.out.println("---------  method_02:" + object.toString() + "  ---------");
    }

    /*反射获取带参数的构造方法*/
    private static void method_03() throws Exception {
        Class c = Class.forName(packageName);
        Constructor constructor = c.getConstructor(String.class, int.class);
        Object object = constructor.newInstance("孙瑞红", 23);
        System.out.println("---------  method_03:" + object.toString() + "  ---------");
    }

    /*
     *  反射获取私有的构造方法运行
     *  不推荐,破坏了程序的封装性,安全性
     *  暴力反射
     */
    private static void method_04() throws Exception {
        Class c = Class.forName(packageName);
        Constructor constructor = c.getDeclaredConstructor(int.class, String.class);
        /*不设置权限会报错：can not access a member of class com.javaee.learning.demo1.Person
         with modifiers "private"*/
        constructor.setAccessible(true);
        Object object = constructor.newInstance(23, "孙瑞红");
        System.out.println("---------  method_04:" + object.toString() + "  ---------");
    }
}
