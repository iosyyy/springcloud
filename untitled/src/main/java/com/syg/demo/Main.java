package com.syg.demo;

import com.syg.Test;
import com.syg.TestImp;

import java.lang.reflect.Proxy;

/**
 * @author 靖鸿宣
 * @since 2021/1/19
 */
public class Main {
    public static void main(String[] args) {

        Test test=new Test();
        TestImp instance = (TestImp) Proxy.newProxyInstance(Test.class.getClassLoader()
                , Test.class.getInterfaces(), (proxy, method, args1) -> {
            if(method.getName().equals("sayHello"))
            {
                String word= (String) args1[0];
                args1[0]=word.replace("nt","**");
            }
            return method.invoke(test, args1);
        });
        System.out.println(instance.sayHello("Hello nt ntNt nt"));
        System.out.println(instance);
    }
}
