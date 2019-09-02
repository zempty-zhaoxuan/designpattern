package com.zempty.improve;
// 该案例对工厂 Factory 做了一个改进，工厂类只定义一个生产方法 produce ，具体生产什么产品有具体的工厂子类型进行加工处理即可
public class OcpDemo {
    public static void main(String[] args) {
        Factory factory = new Bfactory();
        factory.produce();
    }
}

interface Factory {
    A produce();
}

class Bfactory implements Factory {

    public A produce() {
        return new B();
    }
}

class Cfactory implements Factory {
    public A produce() {
        return new C();
    }
}
class A {
    String product;
}

class B extends A {
    B() {
        this.product = "b";
        System.out.println("B 类型的产品生产出来了");
    }
}
class C extends A {
    C() {
        this.product = "c";
        System.out.println("C 类型的产品生产出来了");
    }

}

