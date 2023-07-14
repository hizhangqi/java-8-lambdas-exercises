package com.systeminfos.design.pattern.prototype;

// 原型接口
interface Prototype {
    Prototype clone();

    void setAttribute(String attribute);

    void printAttribute();
}

// 具体原型类
class ConcretePrototype implements Prototype {
    private String attribute;

    public ConcretePrototype(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.attribute);
    }

    @Override
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public void printAttribute() {
        System.out.println("Attribute: " + attribute);
    }
}

/**
 * <pre>
 * 在这个示例中，我们首先定义了一个原型接口Prototype，其中包含了克隆方法clone()，设置属性方法setAttribute()和打印属性方法printAttribute()。
 * 然后，我们实现了具体的原型类ConcretePrototype，它实现了原型接口。在具体原型类中，我们通过实现clone()方法返回一个新的克隆对象，并通过setAttribute()方法设置属性，printAttribute()方法打印属性。
 * 在Main类中，我们首先创建原型对象prototype，并打印其属性。然后，我们使用clone()方法克隆原型对象，得到一个新的克隆对象，并打印其属性。接着，我们修改克隆对象的属性，再次打印原型对象和克隆对象的属性。可以看到，原型对象和克隆对象是相互独立的，修改克隆对象的属性不会影响原型对象。
 * 原型模式通过复制现有对象来创建新对象，而无需通过实例化类来构造对象。通过原型模式，可以避免类的重复初始化和构造过程，提高对象的创建效率。此外，原型模式还允许动态添加或修改对象的属性，从而实现更灵活的对象创建。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 创建原型对象
        Prototype prototype = new ConcretePrototype("Initial Attribute");
        prototype.printAttribute();

        // 克隆原型对象
        Prototype clone = prototype.clone();
        clone.printAttribute();

        // 修改克隆对象的属性
        clone.setAttribute("Modified Attribute");

        // 打印原型对象和克隆对象的属性
        prototype.printAttribute();
        clone.printAttribute();
    }
}
