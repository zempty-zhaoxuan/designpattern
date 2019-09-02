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
