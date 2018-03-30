package com.javaee.learning.demo1;

import java.lang.reflect.Method;

public class GetMethod {
    private static String packageName = "com.javaee.learning.demo1.Person";

    public static void main(String[] args) throws Exception {
        Class c = Class.forName(packageName);
        Object object = c.newInstance();
        /*无参成员方法*/
        Method eat = c.getMethod("eat");
        eat.invoke(object);
        /*有参成员方法*/
        Method sleep = c.getMethod("sleep", String.class, int.class, double.class);
        sleep.invoke(object, "孙瑞红", 10, 8.5);
        /*私有成员方法*/
        Method playGame = c.getDeclaredMethod("playGame");
        playGame.setAccessible(true);
        playGame.invoke(object);
    }
}
