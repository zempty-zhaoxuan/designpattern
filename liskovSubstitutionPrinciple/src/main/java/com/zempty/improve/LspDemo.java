package com.zempty.improve;
//改例子很好的解决了上述重写的问题，通过增加一个接口 Base ，接口中定义标准，A 和 B 去做具体的实现
//这里 B 通过引入 A 的实例，间接地使用了 A 中两个数相减的方法
public class LspDemo {
    public static void main(String[] args) {
        Base base = new A();
        B b = new B(base);
        //使用的仍然是 B 类中的加方法
        int num = b.test1(9, 7);
        int num2 = b.test2(10,2);
        //通过 B 调用 A 中的减方法
        int num3 = b.test3(9, 7);
        System.out.println(num);
        System.out.println(num2);
        System.out.println(num3);
    }
}

interface Base {
    int test1(int a, int b);
}

class A implements Base {
   public int test1(int a, int b) {
        return a - b;
    }
}

class B  implements Base{
    private Base base;
    B(Base base) {
        this.base = base;
    }

    public int test1(int a, int b) {
        return a + b;
    }

    int test2(int a, int b) {
        return a / b;
    }

    int test3(int a, int b) {
       return base.test1(a,b);
    }
}
