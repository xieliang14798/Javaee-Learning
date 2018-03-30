package com.javaee.learning.demo1;

import java.lang.reflect.Field;

public class GetVariable {
    private static String packageName = "com.javaee.learning.demo1.Person";

    public static void main(String[] args) throws Exception {
        Class c = Class.forName(packageName);
        Object object = c.newInstance();

        Field name = c.getField("name");
        name.set(object, "孙瑞红");
        /*age是私有变量*/
        Field age = c.getDeclaredField("age");
        age.setAccessible(true);
        age.set(object, 23);

        System.out.println(object.toString());
    }
}
