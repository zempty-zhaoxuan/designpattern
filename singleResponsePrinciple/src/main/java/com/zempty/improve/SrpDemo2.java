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
