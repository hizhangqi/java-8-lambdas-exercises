package com.systeminfos.design.pattern.state;

// 状态接口
interface State {
    void handle(Context context);
}

// 具体状态类A
class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 A，切换到状态 B");
        context.setState(new ConcreteStateB());
    }
}

// 具体状态类B
class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 B，切换到状态 A");
        context.setState(new ConcreteStateA());
    }
}

// 上下文类
class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA(); // 初始状态为A
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}

/**
 * 它允许一个对象在其内部状态发生改变时改变其行为。状态模式将对象的状态封装成不同的类，使得对象可以根据不同的状态选择不同的行为。下面是一个简单的Java实现状态模式的示例：
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.request();
        context.request();
        context.request();
    }
}
