package com.systeminfos.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

// 定义迭代器接口
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// 定义集合接口
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// 具体迭代器实现
class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private int currentIndex = 0;

    public ListIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public T next() {
        T item = list.get(currentIndex);
        currentIndex++;
        return item;
    }
}

// 具体集合实现
class MyCollection<T> implements IterableCollection<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(items);
    }
}

/**
 * 在上面的示例中，我们首先定义了迭代器接口和集合接口。然后，我们实现了一个具体的迭代器类 ListIterator，它基于Java的 List 实现。接着，我们实现了一个具体的集合类 MyCollection，
 * 它实现了 IterableCollection 接口，并提供了添加元素的方法。最后，在 Main 类中，我们演示了如何使用迭代器来遍历集合中的元素。
 * <p>
 * 需要注意的是，Java标准库中已经提供了许多内置的迭代器实现，如 Iterator 和 Iterable 接口，您可以直接使用这些接口来实现迭代器模式。上述示例只是一个基本的示范，实际项目中的实现可能更加复杂和完善。
 */
public class Main {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection<>();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");

        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
