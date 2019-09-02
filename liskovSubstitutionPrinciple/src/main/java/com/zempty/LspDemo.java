package com.zempty;

public class LspDemo {
    public static void main(String[] args) {
        B b = new B();
        // 其实是想调用的父类 A 中的减方法，但是 B 不小心重写了 A 中的方法
        int num = b.test1(7, 8);
        int num2 = b.test2(6, 3);
        System.out.println(num);
        System.out.println(num2);
    }
}
class A {
    int test1(int a, int b) {
        return a - b;
    }
}

class B extends A {
    int test1(int a, int b) {
        return a + b;
    }

    int test2(int a, int b) {
        return a / b;
    }
}
