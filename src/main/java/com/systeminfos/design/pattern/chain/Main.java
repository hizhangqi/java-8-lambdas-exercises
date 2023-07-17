package com.systeminfos.design.pattern.chain;

/**
 * <pre>
 * 首先，确定职责链中的处理者的共同接口。该接口定义了处理请求的方法。
 * 创建一个抽象处理者类，实现共同接口。在抽象处理者类中，包含一个指向下一个处理者的引用，以形成职责链。
 * 创建具体处理者类，继承抽象处理者类，并实现处理请求的方法。在具体处理者类中，根据自身的职责决定是否处理请求，如果不能处理，则将请求传递给下一个处理者。
 * 在客户端代码中，创建处理者对象，并组织它们形成职责链。然后，向职责链的第一个处理者发送请求。
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setNextHandler(handler2);

        Request request1 = new Request("Type1");
        handler1.handleRequest(request1);

        Request request2 = new Request("Type2");
        handler1.handleRequest(request2);

        Request request3 = new Request("Type3");
        handler1.handleRequest(request3);
    }
}





