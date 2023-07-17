package com.systeminfos.design.pattern.proxy;

class Proxy implements Subject {
    private RealSubject realSubject;
    
    public Proxy() {
        realSubject = new RealSubject();
    }
    
    @Override
    public void doOperation() {
        // 在调用真实对象之前可以添加额外的功能
        System.out.println("Proxy: 执行操作之前的准备");
        
        // 调用真实对象的方法
        realSubject.doOperation();
        
        // 在调用真实对象之后可以添加额外的功能
        System.out.println("Proxy: 执行操作之后的清理");
    }
}