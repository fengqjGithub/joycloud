package com.testTransferValue;

/**
 * @Project: joycloud
 * @Package: com
 * @Author: 冯前进
 * @Date: 2020-05-09 11:16
 * @Description: TODO
 **/
public class TestTransferValue {
    public void changeValue1(int age){
        age=30;
    }
    public void changeValue2(Persion persion){
        persion.setName("XXX");
    }
    public void changeValue3(String str){
       str="XXX";
    }

    public static void main(String[] args) {
        TestTransferValue test =new TestTransferValue();
        int age=20;
        test.changeValue1(age);
        System.out.println("age---"+age);//20

        Persion persion=new Persion("abc");
        test.changeValue2(persion);
        System.out.println("name---"+persion.getName());//xxx

        String str="abc";
        test.changeValue3(str);
        System.out.println("str---"+str);//abc
    }

}
