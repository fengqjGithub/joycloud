package com.testProxy;

/**
 * @Project: joycloud
 * @Package: com.testProxy
 * @Author: 冯前进
 * @Date: 2019-09-12 14:13
 * @Description: TODO
 **/

/**
 * cglib的代理方式不需要传入被代理对象实例即可完成动态代理。
 * cglib和jdk代理有什么区别呢？
 * jdk的代理对象与被代理对象实现了同一接口,底层通过clone()方法,将实现类的方法复制过来在按照invoke中的配置对方法进行增强。
 * 而cglib代理则是代理对象继承了被代理对象的方法,然后自身进行增强。
 * 这两种代理思想在外来的自动生成代码方向会经常被使用,实现完全体代码的复用性。
 */
public class TestProxyMain {
    public static void main(String[] args) {
        MyServiceImpl myService=new MyServiceImpl();
        //JDK代理
        MyServiceJdkProxyFactory factory=new MyServiceJdkProxyFactory();
        factory.setMsi(myService);
        MyService service=factory.getInstance();
        service.add();
        //cglib代理
        MyServiceCglibProxyFactory cglibProxyFactory=new MyServiceCglibProxyFactory();
        MyService instance= cglibProxyFactory.getInstance();
        instance.update();
    }
}
