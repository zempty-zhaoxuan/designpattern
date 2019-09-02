package com.zempty.improve;
/*
* 这个改进的 demo， B 用到 A 中的方法通过依赖去实现
* */
public class CrpDemo {
    public static void main(String[] args) {
        B b = new B();
        b.testB();
    }
}

class A {
    void test() {
        System.out.println("完成一个功能");
    }
    void test2() {
        System.out.println("这是一个多余的方法");
    }
}

class B {
//    通过依赖去达到同样的目的
    private A a;
    void testB() {
        a = new A();
        a.test();
    }
}
