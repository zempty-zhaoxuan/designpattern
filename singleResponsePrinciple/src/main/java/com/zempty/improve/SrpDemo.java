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
