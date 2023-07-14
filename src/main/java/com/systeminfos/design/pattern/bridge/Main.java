package com.systeminfos.design.pattern.bridge;

// 实现接口
interface Implementor {
    void operationImpl();
}

// 具体实现类A
class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现类A的操作");
    }
}

// 具体实现类B
class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现类B的操作");
    }
}

// 抽象类
abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation();
}

// 扩展抽象类A
class RefinedAbstractionA extends Abstraction {
    public RefinedAbstractionA(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        System.out.println("扩展抽象类A的操作");
        implementor.operationImpl();
    }
}

// 扩展抽象类B
class RefinedAbstractionB extends Abstraction {
    public RefinedAbstractionB(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        System.out.println("扩展抽象类B的操作");
        implementor.operationImpl();
    }
}

/**
 * <pre>
 * 在这个示例中，我们首先定义了实现接口Implementor，其中包含了具体实现类所需的操作方法operationImpl()。
 * 然后，我们实现了两个具体实现类ConcreteImplementorA和ConcreteImplementorB，它们分别实现了实现接口。
 * 接下来，我们定义了一个抽象类Abstraction，其中包含了一个实现接口的成员变量。抽象类中还定义了抽象方法operation()。
 * 我们还实现了两个扩展抽象类RefinedAbstractionA和RefinedAbstractionB，它们分别继承了抽象类，并实现了抽象方法。在这些扩展抽象类中，我们通过调用实现接口的方法来实现具体操作。
 * 在Main类中，我们首先创建具体实现类A（ConcreteImplementorA），然后创建扩展抽象类A（RefinedAbstractionA）并将其关联到具体实现类A。通过调用扩展抽象类A的操作方法，实际上会调用具体实现类A的操作。
 * 接着，我们创建具体实现类B（ConcreteImplementorB），并创建扩展抽象类B（RefinedAbstractionB）并关联具体实现类B。通过调用扩展抽象类B的操作方法，实际上会调用具体实现类B的操作。
 * 桥接模式通过将抽象和实现分离，使它们可以独立地变化。这种模式可以减少抽象和实现之间的耦合，提高代码的可扩展性和可维护性。桥接模式适用于在多个维度上扩展一个类的情况，可以实现高度灵活的系统设计。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 创建具体实现类A
        Implementor implementorA = new ConcreteImplementorA();

        // 创建扩展抽象类A并关联具体实现类A
        Abstraction abstractionA = new RefinedAbstractionA(implementorA);

        // 调用扩展抽象类A的操作
        abstractionA.operation();

        // 创建具体实现类B
        Implementor implementorB = new ConcreteImplementorB();

        // 创建扩展抽象类B并关联具体实现类B
        Abstraction abstractionB = new RefinedAbstractionB(implementorB);

        // 调用扩展抽象类B的操作
        abstractionB.operation();
    }
}
