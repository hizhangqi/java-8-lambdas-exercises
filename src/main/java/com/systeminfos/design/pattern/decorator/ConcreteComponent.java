package com.systeminfos.design.pattern.decorator;

public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("执行具体组件的操作");
    }
}