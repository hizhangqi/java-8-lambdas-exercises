package com.systeminfos.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

// 抽象组件
interface Component {
    void operation();
}

// 叶子组件
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " 执行操作");
    }
}

// 容器组件
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite 执行操作");
        for (Component component : children) {
            component.operation();
        }
    }
}

/**
 * <pre>
 * 在这个示例中，我们首先定义了一个抽象组件接口Component，其中包含了执行操作的方法operation()。
 * 然后，我们实现了叶子组件Leaf和容器组件Composite，它们都实现了抽象组件接口。叶子组件表示不可再分的最小单位，而容器组件可以包含其他组件。
 * 在容器组件中，我们使用一个列表来存储子组件，并实现了添加和删除子组件的方法。在执行操作的方法中，容器组件会遍历并调用其子组件的操作方法。
 * 在Main类中，我们首先创建了几个叶子组件和容器组件。然后，我们将叶子组件添加到容器组件中，并将一个容器组件添加到另一个容器组件中。最后，我们调用容器组件的操作方法，整个组合结构会被遍历并执行相应的操作。
 * 组合模式允许我们将对象组合成树形结构，以表示部分-整体的层次结构。通过使用组合模式，我们可以一致地处理单个对象和组合对象，客户端可以统一地对待它们。组合模式可以简化客户端的代码，同时提供了灵活性和可扩展性。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 创建叶子组件
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");
        Component leaf3 = new Leaf("Leaf 3");

        // 创建容器组件
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        // 将叶子组件添加到容器组件中
        composite1.add(leaf1);
        composite1.add(leaf2);

        composite2.add(leaf3);

        // 将容器组件添加到另一个容器组件中
        composite1.add(composite2);

        // 执行操作
        composite1.operation();
    }
}
