package com.zempty;
// 解释一下这个代码：工厂类负责生产 A 类型的产品， A 类型有两个子产品：B 和 C
//这段代码的最大问题就是当 A 类型的产品增加了，现在拓展了一个子产品 D ，这样麻烦就出现了。
//拓展产品线以后必须修改 Factory 的 produce 方法的业务代码
public class OcpDemo {
    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.produce("b");
        factory.produce("c");
    }
}

class Factory {
    A produce(String product) {
        if (product.equals("b")) {
            return new B();
        }
        if (product.equals("c")) {
            return new C();
        }
        return null;
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
