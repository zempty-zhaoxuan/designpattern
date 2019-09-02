package com.zempty;
/*
* 这是一个非常容易理解的一个 demo , B 继承 A ，目的是要使用 A 中的 test（）方法
* 这里就违背类合成复用原则，B 只是用到 A 中的一个方法而已，却把 A 中的 test2() 方法也给继承下来了
* 如果 A 是一个抽象类，里面定义类很多的抽象方法，这样处理就太苦逼了
* */
public class CrpDemp {
    public static void main(String[] args) {
        B b = new B();
        b.test();
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

class B extends A {

}
