package com.systeminfos.design.pattern.abstractfactory;

// 抽象产品A
interface AbstractProductA {
    void operationA();
}

// 具体产品A1
class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("具体产品A1的操作");
    }
}

// 具体产品A2
class ConcreteProductA2 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("具体产品A2的操作");
    }
}

// 抽象产品B
interface AbstractProductB {
    void operationB();
}

// 具体产品B1
class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("具体产品B1的操作");
    }
}

// 具体产品B2
class ConcreteProductB2 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("具体产品B2的操作");
    }
}

// 抽象工厂
interface AbstractFactory {
    AbstractProductA createProductA();

    AbstractProductB createProductB();
}

// 具体工厂1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// 具体工厂2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}

/**
 * <pre>
 * 在这个示例中，我们首先定义了两个抽象产品接口：AbstractProductA和AbstractProductB。然后，我们实现了具体的产品类，如ConcreteProductA1、ConcreteProductA2、ConcreteProductB1和ConcreteProductB2。
 * 接下来，我们定义了一个抽象工厂接口AbstractFactory，其中包含创建产品A和产品B的抽象方法。然后，我们实现了两个具体工厂类ConcreteFactory1和ConcreteFactory2，分别负责创建具体的产品。
 * 在Main类中，我们首先创建具体工厂1（ConcreteFactory1），然后使用该工厂创建产品A1（ConcreteProductA1）和产品B1（ConcreteProductB1）的实例，并调用它们的操作方法。接着，我们创建具体工厂2（ConcreteFactory2），使用该工厂创建产品A2（ConcreteProductA2）和产品B2（ConcreteProductB2）的实例，并调用它们的操作方法。
 * 抽象工厂模式提供了一种将一组相关产品的创建封装在一个工厂接口中的方式。这样可以使客户端与具体产品的实现解耦，并且可以轻松替换不同的具体工厂来创建不同的产品组合。这种模式在需要创建一系列相互关联或依赖的产品对象时非常有用。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 创建具体工厂1
        AbstractFactory factory1 = new ConcreteFactory1();

        // 使用具体工厂1创建产品A1
        AbstractProductA productA1 = factory1.createProductA();
        productA1.operationA();

        // 使用具体工厂1创建产品B1
        AbstractProductB productB1 = factory1.createProductB();
        productB1.operationB();

        // 创建具体工厂2
        AbstractFactory factory2 = new ConcreteFactory2();

        // 使用具体工厂2创建产品A2
        AbstractProductA productA2 = factory2.createProductA();
        productA2.operationA();

        // 使用具体工厂2创建产品B2
        AbstractProductB productB2 = factory2.createProductB();
        productB2.operationB();
    }
}
