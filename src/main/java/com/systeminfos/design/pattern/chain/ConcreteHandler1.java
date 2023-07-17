package com.systeminfos.design.pattern.chain;


class ConcreteHandler1 extends AbstractHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Type1")) {
            System.out.println("ConcreteHandler1: 处理请求");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class ConcreteHandler2 extends AbstractHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Type2")) {
            System.out.println("ConcreteHandler2: 处理请求");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}