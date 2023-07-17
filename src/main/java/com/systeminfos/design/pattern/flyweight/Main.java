package com.systeminfos.design.pattern.flyweight;

/**
 * <pre>
 * 首先，确定你要共享的对象的内部状态和外部状态。内部状态是可以共享的，而外部状态是根据上下文而变化的。
 * 创建一个享元接口，定义对象的共享方法。该接口可以包含对内部状态和外部状态的操作。
 * 创建具体的享元类，实现享元接口。在具体享元类中，定义并维护对象的内部状态，并实现共享方法。
 * 创建享元工厂类，用于创建和管理享元对象。享元工厂类可以维护一个享元池，用于存储和管理已创建的享元对象。
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("A");
        flyweight1.operation("External state 1");

        Flyweight flyweight2 = factory.getFlyweight("B");
        flyweight2.operation("External state 2");

        Flyweight flyweight3 = factory.getFlyweight("A");
        flyweight3.operation("External state 3");
    }
}