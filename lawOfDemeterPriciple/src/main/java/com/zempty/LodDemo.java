package com.zempty;
/*
* 这是一个相当简单的 demo，总共就三个类 A ，B，C
* 在这里 A 类中出现了一个问题： A 中的 testA 的方法中出现类一个间接的朋友 C
* 这个例子违反了迪米特原则，A 中只需要用到 B 就可以了，不可以出现 C
*
* */
public class LodDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.testA(b);
    }
}
class A {
    void testA(B b) {
        C c = b.testB();
        c.testC();
    }
}
class B{
    C testB() {
        return new C();
    }
}
class C{

    void testC() {
        System.out.println("c的方法运行了");
    }
}
