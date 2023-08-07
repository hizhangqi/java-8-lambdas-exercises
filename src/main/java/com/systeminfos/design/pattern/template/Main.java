package com.systeminfos.design.pattern.template;

// 抽象模板类
abstract class AbstractTemplate {
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    protected abstract void step1();

    protected abstract void step2();

    protected abstract void step3();
}

// 具体模板类A
class ConcreteTemplateA extends AbstractTemplate {
    @Override
    protected void step1() {
        System.out.println("ConcreteTemplateA - Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteTemplateA - Step 2");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteTemplateA - Step 3");
    }
}

// 具体模板类B
class ConcreteTemplateB extends AbstractTemplate {
    @Override
    protected void step1() {
        System.out.println("ConcreteTemplateB - Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteTemplateB - Step 2");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteTemplateB - Step 3");
    }
}

/**
 * 模板方法模式可以帮助实现算法的骨架，将某些步骤的具体实现交给子类来完成。这样可以提高代码的复用性和可维护性，同时保持了算法的一致性。在实际项目中，可以根据实际需求来设计和使用模板方法模式，将公共的部分抽象到父类中，而将变化的部分留给子类来实现。
 */
public class Main {
    public static void main(String[] args) {
        AbstractTemplate templateA = new ConcreteTemplateA();
        templateA.templateMethod();

        AbstractTemplate templateB = new ConcreteTemplateB();
        templateB.templateMethod();
    }
}
