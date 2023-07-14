package com.systeminfos.design.pattern.strategy;

public class Context {
    private Strategy strategy;
     public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
     public void executeStrategy() {
        strategy.execute();
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy();
        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy();
    }
}