package com.systeminfos.design.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

// 中介者接口
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

// 具体中介者实现
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}

// 同事类接口
interface Colleague {
    void sendMessage(String message);

    void receiveMessage(String message);
}

// 具体同事类
class ConcreteColleague implements Colleague {
    private Mediator mediator;
    private String name;

    public ConcreteColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " 发送消息: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " 收到消息: " + message);
    }
}

/**
 * 在上面的示例中，我们首先定义了中介者接口 Mediator 和同事类接口 Colleague。然后，我们实现了一个具体的中介者类 ConcreteMediator，它维护了一个同事对象的列表，并实现了 sendMessage 方法来转发消息给其他同事。接着，我们实现了一个具体的同事类 ConcreteColleague，它在发送消息时会调用中介者的方法。
 * <p>
 * 在 Main 类中，我们演示了如何使用中介者模式。首先，创建一个中介者对象并创建几个同事对象，然后将同事对象注册到中介者中，最后，通过其中一个同事对象发送消息，消息会被中介者转发给其他同事。
 * <p>
 * 需要注意的是，中介者模式可以帮助降低对象之间的耦合性，但过度使用中介者可能会导致中介者对象变得过于复杂。在实际项目中，需要根据具体情况来合理设计和使用中介者模式。
 */
public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague colleague1 = new ConcreteColleague(mediator, "Colleague 1");
        Colleague colleague2 = new ConcreteColleague(mediator, "Colleague 2");
        Colleague colleague3 = new ConcreteColleague(mediator, "Colleague 3");

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);
        mediator.addColleague(colleague3);

        colleague1.sendMessage("Hello, everyone!");
    }
}
