package com.systeminfos.design.pattern.singleton;

/**
 * 饿汉式单例
 */
public class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    // 私有构造函数，防止外部实例化
    private Singleton2() {
    }

    // 获取单例对象的实例
    public static Singleton2 getInstance() {
        return instance;
    }
}
