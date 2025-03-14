package com.systeminfos.design.pattern.singleton;

/**
 * <pre>
 * 多线程下的创建方式
 * </pre>
 */
public class Singleton3 {
    //让其在线程本地缓存失效，直接刷新到主存里面去
    private static volatile Singleton3 instance;

    // 私有构造函数，防止外部直接实例化
    private Singleton3() {
    }

    // 全局访问点，获取唯一实例
    public static Singleton3 getInstance() {
        if (null == instance) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
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
