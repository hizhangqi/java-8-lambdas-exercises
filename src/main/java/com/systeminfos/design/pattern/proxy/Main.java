package com.systeminfos.design.pattern.proxy;

/**
 * <pre>
 * 首先，确定你要代理的对象和代理对象共同实现的接口。
 * 创建一个真实对象（被代理对象），它实现了共同的接口。
 * 创建一个代理对象，它也实现了共同的接口，并持有一个真实对象的引用。
 * 在代理对象中，实现对真实对象方法的调用，并在必要时添加额外的功能或控制。
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.doOperation();
    }
}