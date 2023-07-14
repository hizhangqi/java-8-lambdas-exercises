package com.systeminfos.design.pattern.strategy;

/**
 * <pre>
 * 在这个示例中，我们定义了一个策略接口（Strategy），具体的策略类（ConcreteStrategyA和ConcreteStrategyB）实现了这个接口。Context类是上下文类，持有一个策略对象，并通过executeStrategy()方法来执行具体的策略。
 * 在Main类中，我们创建了具体的策略对象，并将其传递给上下文对象。然后，通过调用executeStrategy()方法，可以根据当前设置的策略来执行相应的操作。
 * 这个示例展示了策略者模式的基本结构和用法，通过使用不同的策略对象，可以在运行时选择不同的行为或算法，以实现灵活的行为变化。
 * </pre>
 */
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