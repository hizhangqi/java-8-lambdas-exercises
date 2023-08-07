package com.systeminfos.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

// 备忘录类
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 原发器类
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }

    public void printState() {
        System.out.println("Current State: " + state);
    }
}

// 管理者类
class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}

/**
 * 在上面的示例中，我们首先定义了备忘录类 Memento，它包含一个用于保存状态的字段。然后，我们实现了原发器类 Originator，它有一个状态字段，可以设置状态、保存状态到备忘录对象并从备忘录对象恢复状态。接着，我们实现了管理者类 Caretaker，它维护了备忘录对象的列表，可以添加和获取备忘录对象。
 * <p>
 * 在 Main 类中，我们演示了如何使用备忘录模式。我们首先创建一个原发器对象和一个管理者对象。然后，我们设置原发器的状态并保存到备忘录，修改状态后再恢复到之前的状态。
 * <p>
 * 需要注意的是，备忘录模式用于保存和恢复对象的状态，但在实际项目中，可能需要考虑状态的保存和恢复方式，以及备忘录对象的管理和维护等问题。备忘录模式可以帮助我们实现状态的撤销和恢复功能，从而增加程序的灵活性和可维护性。
 */
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State 1");
        originator.printState();

        // 保存状态
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State 2");
        originator.printState();

        // 恢复到之前的状态
        originator.restoreStateFromMemento(caretaker.getMemento(0));
        originator.printState();
    }
}
