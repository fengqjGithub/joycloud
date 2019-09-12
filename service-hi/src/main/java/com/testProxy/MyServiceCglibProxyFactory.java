package com.testProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Project: joycloud
 * @Package: com.testProxy
 * @Author: 冯前进
 * @Date: 2019-09-12 14:19
 * @Description: TODO
 **/
public class MyServiceCglibProxyFactory implements MethodInterceptor {
    public MyService getInstance() {
        //创建生成代理对象的enhancer对象
        Enhancer en = new Enhancer();
        //设置需要被代理对象的class
        en.setSuperclass(MyServiceImpl.class);
        //设置增强的方法
        en.setCallback(this);
        //创建被代理对象
        MyServiceImpl create = (MyServiceImpl) en.create();
        return create;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始");
        Object invoke=methodProxy.invokeSuper(o,objects);
        System.out.println("结束");
        return invoke;
    }
}
