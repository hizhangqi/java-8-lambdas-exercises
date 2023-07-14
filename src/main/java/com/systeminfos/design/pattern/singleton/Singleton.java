package com.systeminfos.design.pattern.singleton;

public class Singleton {
    private static Singleton instance;

    // 私有构造函数，防止外部直接实例化
    private Singleton() {
    }

    // 全局访问点，获取唯一实例
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 其他实例方法
    public void doSomething() {
        // ...
    }
}
