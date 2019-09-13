package com.testLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Project: joycloud
 * @Package: com.testLambda
 * @Author: 冯前进
 * @Date: 2019-08-19 15:35
 * @Description: TODO
 **/
public class AppServer {
    List<Apple> appleStore = new ArrayList<>();

    public List<Apple> getAppleListBycolor(String color) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : appleStore) {
            if (apple.getColor().equals(color)) {
                res.add(apple);
            }
        }
        return res;
    }

    public List<Apple> getAppleList(Predicate<Apple> predicate) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : appleStore) {
            if(predicate.test(apple)){
                res.add(apple);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new AppServer().getAppleList(new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });
        new AppServer().getAppleList(apple -> apple.getColor().equals("red"));
        Test2 test2=String::new;
        test2.mytest2();
    }
    interface Test2{
        String mytest2();
//        String mytest3();
    }

}
