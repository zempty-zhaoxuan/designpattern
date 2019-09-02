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
