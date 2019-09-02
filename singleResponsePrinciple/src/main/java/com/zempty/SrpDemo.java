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