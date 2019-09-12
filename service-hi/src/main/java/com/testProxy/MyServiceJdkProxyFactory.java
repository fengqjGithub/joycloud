package com.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Project: joycloud
 * @Package: com.testProxy
 * @Author: 冯前进
 * @Date: 2019-09-12 11:47
 * @Description: TODO
 **/

/**
 * jdk提供的动态代理
 */
public class MyServiceJdkProxyFactory implements InvocationHandler {
    private MyServiceImpl msi;

    public MyServiceImpl getMsi() {
        return msi;
    }

    public void setMsi(MyServiceImpl msi) {
        this.msi = msi;
    }

    public MyService getInstance() {
        MyService newProxyInstance = (MyService) Proxy.newProxyInstance(this.getClass().getClassLoader(), MyServiceImpl.class.getInterfaces(), this);
        return newProxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始调用");
        Object incoke = method.invoke(msi, args);
        System.out.println("调用结束");
        return incoke;
    }
}
