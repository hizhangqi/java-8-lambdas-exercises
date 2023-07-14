package com.systeminfos.design.pattern.adapter;

// 目标接口
interface Target {
    void request();
}

// 适配者类
class Adaptee {
    void specificRequest() {
        System.out.println("适配者的特殊请求");
    }
}

// 类适配器
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

// 对象适配器
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

/**
 * <pre>
 * 在这个示例中，我们首先定义了目标接口Target，其中包含了客户端所期望的请求方法request()。
 * 然后，我们定义了一个适配者类Adaptee，其中包含了一个特殊的请求方法specificRequest()。
 * 接着，我们实现了一个类适配器ClassAdapter，它继承了适配者类Adaptee并同时实现了目标接口Target。在类适配器中，我们重写了目标接口的方法，并在方法内部调用适配者类的特殊请求方法。
 * 我们还实现了一个对象适配器ObjectAdapter，它持有一个适配者类的实例，并同时实现了目标接口Target。在对象适配器中，我们在目标接口的方法内部调用适配者类的特殊请求方法。
 * 在Main类中，我们首先创建了一个类适配器对象，并调用其请求方法。然后，我们创建了一个适配者对象和一个对象适配器对象，并调用对象适配器的请求方法。
 * 适配器模式用于将一个类的接口转换成客户端所期望的接口。类适配器通过继承适配者类来实现适配，而对象适配器通过持有适配者类的实例来实现适配。适配器模式可以使原本接口不兼容的类能够一起工作，提高代码的复用性和灵活性。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 使用类适配器
        Target classAdapter = new ClassAdapter();
        classAdapter.request();

        // 使用对象适配器
        Adaptee adaptee = new Adaptee();
        Target objectAdapter = new ObjectAdapter(adaptee);
        objectAdapter.request();
    }
}
