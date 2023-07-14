package com.systeminfos.design.pattern.builder;

// 产品类
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("Product Parts:");
        System.out.println("Part A: " + partA);
        System.out.println("Part B: " + partB);
        System.out.println("Part C: " + partC);
    }
}

// 抽象建造者
interface Builder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getResult();
}

// 具体建造者A
class ConcreteBuilderA implements Builder {
    private Product product;

    public ConcreteBuilderA() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Builder A - Part A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Builder A - Part B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Builder A - Part C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// 具体建造者B
class ConcreteBuilderB implements Builder {
    private Product product;

    public ConcreteBuilderB() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Builder B - Part A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Builder B - Part B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Builder B - Part C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// 指导者
class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

/**
 * <pre>
 * 在这个示例中，我们首先定义了产品类Product，它包含了多个部件（partA、partB和partC），以及展示产品的方法show()。
 * 然后，我们定义了一个抽象建造者接口Builder，其中包含了创建各个部件的抽象方法，以及获取最终产品的方法getResult()。
 * 接下来，我们实现了两个具体建造者类ConcreteBuilderA和ConcreteBuilderB，分别实现了抽象建造者接口。每个具体建造者类负责创建产品的不同部件，并实现了获取最终产品的方法。
 * 在Director类中，我们定义了一个指导者，它包含一个建造者对象。通过setBuilder()方法，我们可以设置具体的建造者。construct()方法指导建造者依次创建产品的各个部件，并返回最终构建的产品。
 * 在Main类中，我们首先创建指导者对象director。然后，我们创建具体建造者A（ConcreteBuilderA），并将其设置给指导者。通过调用指导者的construct()方法，可以构建具体建造者A创建的产品，并调用show()方法展示产品的部件。接着，我们创建具体建造者B（ConcreteBuilderB），通过指导者构建具体建造者B创建的产品，并展示其部件。
 * 建造者模式通过将产品的构建过程与表示分离，可以灵活地构建不同的产品对象，同时也使得产品的构建过程更加可控和可扩展。它适用于构建复杂对象的情况，可以将对象的构建过程抽象出来，并允许按步骤或组合方式构建对象。
 * </pre>
 */
// 示例使用
public class Main {
    public static void main(String[] args) {
        // 创建指导者
        Director director = new Director();

        // 创建具体建造者A
        Builder builderA = new ConcreteBuilderA();

        // 指导者使用具体建造者A构建产品
        director.setBuilder(builderA);
        Product productA = director.construct();
        productA.show();

        // 创建具体建造者B
        Builder builderB = new ConcreteBuilderB();

        // 指导者使用具体建造者B构建产品
        director.setBuilder(builderB);
        Product productB = director.construct();
        productB.show();
    }
}
