package com.zempty.improve;

// 针对上面的情况进行改进，拆分接口
public class IspDemo {

    public static void main(String[] args) {
        // a 中用到了接口中的 test1 ，test2 , test3 三个方法，c 是接口的实现类
        A a = new A();
        C c = new C();
        a.test1(c);
        a.test2(c);
        a.test3(c);
        System.out.println("==========================================================");
        // b 中用到了接口中的 test1 , test4 , test5 三个方法，d 是接口的实现类
        B b = new B();
        D d = new D();
        b.test1(d);
        b.test4(d);
        b.test5(d);
    }

}


// A class
class A {
    void test1(Test1 test) {
        test.test1();
    }

    void test2(Test2 test) {
        test.test2();
    }

    void test3(Test2 test) {
        test.test3();
    }
}

// B class
class B {

    void test1(Test1 test) {
        test.test1();
    }

    void test4(Test3 test) {
        test.test4();
    }

    void test5(Test3 test) {
        test.test5();
    }
}


// 把一个接口拆分成三个接口
interface Test1 {
    void test1();
}

interface Test2{
    void test2();

    void test3();
}

interface Test3{
    void test4();

    void test5();
}

// 仅仅实现业务需要的几个方法
class C implements Test1,Test2{

    public void test1() {
        System.out.println("test1 方法被调用了");
    }

    public void test2() {
        System.out.println("test2 方法被调用了");
    }

    public void test3() {
        System.out.println("test3 方法被调用了");
    }

}

// 仅仅实现业务需要的几个方法
class D implements Test1,Test3{

    public void test1() {
        System.out.println("test1 方法被调用了");
    }

    public void test4() {
        System.out.println("test4 方法被调用了");
    }

    public void test5() {
        System.out.println("test5 方法被调用了");
    }
}


