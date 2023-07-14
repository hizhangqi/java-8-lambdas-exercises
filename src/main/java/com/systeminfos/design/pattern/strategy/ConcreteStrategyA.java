package com.systeminfos.design.pattern.strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        // 实现具体的策略A
        System.out.println("实现具体的策略A");
    }
}