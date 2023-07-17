package com.systeminfos.design.pattern.decorator;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    
    @Override
    public void operation() {
        super.operation();
        // 添加额外的功能
        System.out.println("执行具体装饰器的操作");
    }
}