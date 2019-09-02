package com.zempty.improve;
/*
* 分析一下这个改进的 demo ，同上一个 demo 的效果相同
* 但是这个例子中 A 中只有一个 B 而已
* A 中的 C 交给了 C 的直接朋友 B 去处理了
* B 暴露给 A 的只是一个可以调用的方法而已
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
      b.testB();
    }
}
class B{
    private C c;
    void testB() {
        c = new C();
        this.addTest(c);
    }

// 新添加的调用 C 的方法 testC
   private void addTest(C c ) {
        c.testC();
    }
}
class C{

    void testC() {
        System.out.println("c的方法运行了");
    }
}
