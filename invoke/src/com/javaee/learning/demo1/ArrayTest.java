package com.javaee.learning.demo1;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*定义集合类,泛型Boolean
  要求向集合中添加Integer类型*/
public class ArrayTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Boolean> list = new ArrayList<>();
        list.add(false);
//        list.add(123); 直接这样会报错
        Class c = list.getClass();
        Method add = c.getMethod("add", Object.class);
        add.invoke(list,23);
        add.invoke(list,10086);
        add.invoke(list,123456);
        add.invoke(list,23333);
        System.out.println(list);
    }
}
