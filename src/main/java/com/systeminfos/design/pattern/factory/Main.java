package com.systeminfos.design.pattern.factory;

// 抽象产品
interface Product {
    void operation();
}

// 具体产品A
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("具体产品A的操作");
    }
}

// 具体产品B
class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("具体产品B的操作");
    }
}

// 工厂接口
interface Factory {
    Product createProduct();
}

// 具体工厂A
class ConcreteFactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

// 具体工厂B
class ConcreteFactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}


/**
 * <pre>
 * 在这个示例中，我们定义了一个抽象产品接口（Product），具体的产品类（ConcreteProductA和ConcreteProductB）实现了这个接口。
 * 接下来，我们定义了一个工厂接口（Factory），具体的工厂类（ConcreteFactoryA和ConcreteFactoryB）实现了这个接口。每个具体工厂类负责创建具体产品的实例。
 * 在Main类中，我们首先创建具体工厂A（ConcreteFactoryA），然后使用该工厂创建产品A（ConcreteProductA）的实例，并调用产品A的操作。接着，我们创建具体工厂B（ConcreteFactoryB），使用该工厂创建产品B（ConcreteProductB）的实例，并调用产品B的操作。
 * 工厂模式通过将对象的创建委托给工厂类，实现了创建对象的解耦。这样可以隐藏具体产品的实现细节，并提供一个统一的接口供客户端使用，提高了代码的灵活性和可维护性。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 创建具体工厂A
        Factory factoryA = new ConcreteFactoryA();

        // 使用具体工厂A创建产品A
        Product productA = factoryA.createProduct();
        productA.operation();

        // 创建具体工厂B
        Factory factoryB = new ConcreteFactoryB();

        // 使用具体工厂B创建产品B
        Product productB = factoryB.createProduct();
        productB.operation();
    }
}
