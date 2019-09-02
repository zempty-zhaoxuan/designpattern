#### 设计模式的理解

能写出好的代码是一个程序员的追求，就像武侠小说中的绝世神功，侠客们梦寐以求。设计模式应该是程序员江湖中的神功吧。

设计模式存在的目的：
设计模式是为了让程序(软件)，具有更好
1. 代码重用性 (即:相同功能的代码，不用多次编写)
2. 可读性 (即:编程规范性, 便于其他程序员的阅读和理解)
3. 可扩展性 (即:当需要增加新的功能时，非常的方便，称为可维护)
4. 可靠性 (即:当我们增加新的功能后，对原来的功能没有影响)
5. 使程序呈现高内聚，低耦合的特性
6. 设计模式包含了面向对象的精髓，“懂了设计模式，你就懂了面向对象分析和设计(OOA/D)的精要”
设计模式的七大原则：
- 单一职责原则（Single Responsibility Principle, SRP）
- 接口隔离原则 (Interface Segregation Principle)
- 依赖倒转原则 (Dependence Inversion Principle)
- 里氏替换原则 (Liskov Substitution Principle)
- 开闭原则 (Open-Closed Principle)
- 迪米特法则（Law Of Demeter）
- 合成复用原则 (Composite/Aggregate Reuse Principle)

#### 设计模式-单一职责原则的理解（SRP）
对类来说的，即一个类应该只负责一项职责。如类 A 负责两个不同职责:职责 1，职责 2。当职责 1 需求变更而改变 A 时，可能造成职责 2 执行错误，所以需要将类 A 的粒度分解为 A1，A2。
简单来说：一个类最好只负责一项职责。
下面用代码来详细描述一下单一职责，方便理解：
```cpp
package com.zempty;
//该 demo 就存在了一个问题： 飞机多是在空中飞行的，都集中在 vehicle 类中就显得不合适了
public class SrpDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("巴士");
        vehicle.run("摩托");
        vehicle.run("飞机");
    }

}
class Vehicle {
    void run(String vehicle){
        System.out.println(vehicle +"在公路上运行");
    }
}
```
使用单一职责原则改进如下：

```cpp
package com.zempty.improve;
// 该案例把 vehicle 的职责进行一个拆分，飞机飞的功能单独定义
public class SrpDemo {

    public static void main(String[] args) {
        Vehicvle vehicvle = new Vehicvle();
        vehicvle.run("巴士");
        vehicvle.run("摩托");
        AirPlane airPlane = new AirPlane();
        airPlane.run("飞机");
    }

}
class Vehicvle{
    void run(String vehicle) {
        System.out.println(vehicle+"在公路上运行");
    }
}

class AirPlane{
    void run(String plane) {
        System.out.println(plane +"在天空中飞着");
    }
}
```
进一步的进行改进，通过增加方法，通过方法实现单一职责：
```cpp
package com.zempty.improve;

// 有时候可以通过通过添加方法进行单一职责的实现，可以有效的避免类过多，如果添加的方法过多，建议添加类比较好
public class SrpDemo2 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("巴士");
        vehicle.run("摩托");
        vehicle.fly("飞机");
    }
}
class Vehicle{
    void run(String vehicle) {
        System.out.println(vehicle +"在公路上跑着");
    }

    void fly(String plane) {
        System.out.println(plane + "在天空中飞着");
    }
}
```

有时候可以通过添加适当的方法来实现单一职责，这样可以减少类的数量，但是方法的数量可能回增加。
单一职责原则可以降低类的复杂度，一个类只负责一项职责；类的可读性比较好，维护起来比较方便。
通常情况下，我们应该遵守单一职责的原则，如果业务逻辑足够的简单，可以适当的在代码级违反单一职责原则，如上述的第三个例子，类中的方法数量不多，可以通过方法级别实现单一职责。


#### 设计模式-接口隔离原则 (Interface Segregation Principle)

在写代码的时候有时候会碰到这样的一个情况：接口中的方法很多，可是当前业务逻辑能用到的也就几个方法而已，实现类要不要实现接口中的所有方法呢？
接口隔离原则谈的就是解决这样的一个问题的，接口隔离原则就是拆分接口，让接口做到最小化，需要用到什么，接口就定义什么方法。

实例如下所示：

代码呈现如下所示：
```cpp
package com.zempty;

public class IspDemp {

    public static void main(String[] args) {

        // a 中用到了接口中的 test1 ，test2 , test3 三个方法，c 是接口的实现类
        A a = new A();
        C c = new C();
        a.test1(c);
        a.test2(c);
        a.test3(c);

        System.out.println("===============================");
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
   void test1(Test test) {
        test.test1();
    }

    void test2(Test test) {
        test.test2();
    }

    void test3(Test test) {
        test.test3();
    }
}

// B class
class B {

    void test1(Test test) {
        test.test1();
    }

    void test4(Test test) {
        test.test4();
    }

    void test5(Test test) {
        test.test5();
    }
}

// interface Test
 interface Test{

    void test1();

    void test2();

    void test3();

    void test4();

    void test5();

}


// class C
class C implements Test {


   public void test1() {
        System.out.println("test1 方法被调用了");
    }

    public void test2() {
        System.out.println("test2 方法被调用了");
    }


    public void test3() {
        System.out.println("test3 方法被调用了");
    }


    public void test4() {
        System.out.println("test4 方法被调用了");
    }


    public void test5() {
        System.out.println("test5 方法被调用了");
    }
}

class D implements Test{

    public void test1() {
        System.out.println("test1 方法被调用了");
    }


    public void test2() {
        System.out.println("test2 方法被调用了");
    }


    public void test3() {
        System.out.println("test3 方法被调用了");
    }


    public void test4() {
        System.out.println("test4 方法被调用了");
    }


    public void test5() {
        System.out.println("test5 方法被调用了");
    }
}
```
分析上述代码：从 main 方法中可以看到 A ,B 两个类分别用到了接口 Test 中的 test1 , test2 , test3  和 test1 ,test4 , test5 ，**这里有一个问题就是 A 中用到的接口实现类 C 中起到实质作用的就是 test1 ，test2 , test3 三个方法而已，其余方法多余了，根本用不到，但是仍然需要去实现 Test 接口中的其它方法。**

下面遵守接口隔离原则进行一个改进如下：
```cpp
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
        System.out.println("=========================================");
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
```
改进后的方法拆分了接口，让实现类 C 和 D 只实现业务相关的方法，避免了不必要的实现。


#### 设计模式-依赖倒转原则(Dependence Inversion Principle)

依赖倒转原则是指抽象不应该依赖细节，细节应该依赖抽象，依赖倒转的中心思想是面向接口编程。
相对于细节的多变性，抽象的东西要稳定的多。抽象呈现的是骨架，细节的呈现可以多种多样。这里的抽象在 Java 的世界里可以理解成是接口或者是抽象类。
我们在使用 spring 框架的过程中可以体会到我们经常在各种 ctroller 中注入的是 service 的抽象类， service 层注入的是 dao 层的抽象类。
下面用代码来相信说一下这个原则：
```cpp
package com.zempty;
// 该段代码存在的问题就是如果，旅游坐飞机怎么班呢？这样拓展起来就会很麻烦
public class DIPDemo {
    public static void main(String[] args) {
        Car car = new Car("bus");
        Traveling traveling = new Traveling();
        traveling.travel(car);
    }
}
class Traveling {
    void travel(Car car) {
        System.out.println("我的旅游工具是 "+ car.getName());
    }
}
class Car {
    private String name;
    Car(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
```

分析上述代码可以看到一个问题，如果旅游的方式是飞机怎么办呢？这样拓展起来就比较麻烦了。因此，我们做一个改进：
```cpp
package com.zempty.improve;

public class DIPDemo {
    public static void main(String[] args) {
        Car car = new Car("bus");
        Plane plane = new Plane("飞机");
        Traveling traveling = new Traveling();
        traveling.travel(plane);
        traveling.travel(car);
    }
}

class Traveling {
    void travel(Tool tool) {
        System.out.println("我的旅游工具是 "+ tool.getName());
    }
}

interface Tool{
    String getName();
}

class Car implements Tool {
    private String name;
    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
class Plane implements Tool{
    private String name;

    Plane(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```
上述例子我们可以看到旅游类里面我们传入的是一个 Tool ，各种交通工具继承 Tool 接口，这样就方便我们更好的拓展各种交通工具类了。
请记住依赖倒转原则，核心是面向接口进行编程，类和类之间的依赖关系最好使用抽象类或者是接口。

#### 里氏替换原则(Liskov Substitution Principle)

什么是里氏替换原则呢？里氏替换原则讲的是继承的问题，继承通常会使类之间的耦合度增强，如果拓展父类可能会使子类受到影响，如果子类重写父类的方法，父类中的方法将会显得多余，假如父类中有了具体的方法实现，那么子类请不要重写这个方法。
里氏替换的原则告诉我们当我们在使用继承的时候，子类最好的做法是不要继承父类已经实现的方法，继承容易增强类之间的的耦合性，最好的做法是使用类之间的依赖，组合，聚和来解决问题。

下面用 demo 来说明一下问题：
```cpp
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
```
上面的这个例子，B 想使用父类 A 中的两数相减的方法是做不到了，因为重写了父类中的方法，那么应当如何进行改进呢？
```cpp
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
```
上面的这个例子做了一个很好的改进，为了使用 A 中的方法，B 不在继承 A ，B中引入了 A , 这里面还使用了依赖倒转原则，没有直接在 B 中引入 A 的实例，而是通过在 B 中引入  A 的接口类 Base ，在 main 方法中具体使用的时候才注入 A 的实例对象，从而达到了使用 A 中方法的目的。

####  开闭原则(Open-Closed Principle)

一款好的软件就是容易拓展功能，拓展功能的时候不会影响其它的性能。设计模式的出现也就是力求做到这一点：对拓展开放，对修改关闭。
用抽象构建基本框架，用实现展现具体的细节，尽量不去修改代码，有需求在现有的功能上去拓展就好。

下面看一个 demo 进行分析如下：
```cpp
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
```
上面这个例子就违反了开闭原则，如果我新增加了一个 A 类型的产品线必须要修改代码来实现功能需求，开闭原则提倡的是不修改，只拓展。

改进后的代码如下：
```cpp
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
```
经过这样改造以后，当拓展产品线的时候就不会修改代码，我们只需要把关注点放在要关注的功能上就好，拓展哪一条产品线我就组建一个该产品线的一个小工厂。
开闭原则在软件设计当中是非常重要的一个原则，毕竟在原有的软件上加功能要比改功能要舒服的多。

#### 迪米特法则（Law Of Demeter）

迪米特法则讲的是类之间的耦合关系，如果两个类之间建立耦合关系以后，最好不要暴露第三方的类，就像 A 依赖 B ，B 依赖 C ，那么请不要把 C 暴露在 A 当中。
迪米特法则又叫最少知道原则，一个类对自已依赖的类知道的越少就越好，也就是说被依赖的类不管多么的复杂，都把逻辑封装在类的内部，对外只需要暴露自己的 public 方法就好了。
下面根据迪米特法则讲一个概念：直接朋友？ 啥是直接朋友呢？两个类之间存在耦合关系，我们就说两个类之间是朋友关系。耦合的方式有很多，依赖，关联，组合，聚合等，如果把耦合的对象出现在成员变量中，方法参数当中，方法的返回值当在，那么这个耦合关系就是直接朋友。如果出现在局部变量中的类就不是直接的朋友，类最好不要以局部变量的形式出现在类的内部。
迪米特法则遵守的就是两个类只构成直接朋友的关系。

下面来参考两个 demo ：
```cpp
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
```
上面的这个例子 A 中有一个 C ，这个 C 的存在违背了迪米特法则。

下面改进代码如下：
```cpp
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
```
这个改进的 demo 中 A 和 B 是直接的朋友关系，B 和 C是直接的朋友关系，两个类之间没有第三者的存在。

记住迪米特法则：你是我的朋友，关于你朋友的信息，你告诉我就行了，我不需要正面去接触你的朋友。

#### 合成复用原则 (Composite/Aggregate Reuse Principle)

合成复用原则是一个非常容易理解的原则，原则的要义就是两个类之间发生关系最好不要使用继承，用依赖的形式去呈现。
继承会把两个类之间的关系强相关，如果对父类进行改动就会影响子类。合成复用原则的意思是 A 用到 B ，请把 B 依赖到 A 中，最好不要使用继承去实现。
合成复用原则弱化了类之间的关系，A 依赖 B ， B 只对 A 提供方法，具体的方法实现细节 A 看不到，也无法进行修改。

下面看两个 demo :
```cpp
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
```
改进后的 demo 如下 ：
```cpp
package com.zempty.improve;
/*
* 这个改进的 demo， B 用到 A 中的方法是通过依赖去实现的
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
```
通过上面的 demo 我们可以发现两个类之间通过依赖要优于继承。
记住合成复用原则：减少继承的使用，用依赖去实现效果更好。