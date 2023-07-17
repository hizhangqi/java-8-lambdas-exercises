package com.systeminfos.design.pattern.proxy;

class RealSubject implements Subject {
    @Override
    public void doOperation() {
        System.out.println("RealSubject: 执行操作");
    }
}