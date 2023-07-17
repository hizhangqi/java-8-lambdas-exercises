package com.systeminfos.design.pattern.decorator;

public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator(component);
        component.operation();
    }
}