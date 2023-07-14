package com.systeminfos.design.pattern.singleton;

/**
 * <pre>
 * 在这个示例中，Singleton类只有一个私有的静态成员变量instance，用于保存单例实例。构造函数被声明为私有，以防止外部类实例化该类。
 * getInstance()方法是获取单例实例的入口。在方法内部，使用双重检查锁定（double-checked locking）来确保线程安全和延迟实例化。首先检查instance是否已经被实例化，如果没有，则进入同步块。在同步块内部再次检查instance是否为null，如果是，则实例化一个新的Singleton对象，并将其赋值给instance。
 * 这种实现方式称为“双重检查锁定”，可以在多线程环境下保证单例的唯一性和线程安全性。通过延迟实例化，在首次调用getInstance()方法时才创建实例，提高了性能。
 * 请注意，这个示例实现了简单的单例模式，但在特定的情况下可能会存在问题。在使用单例模式时，应根据具体需求和线程安全性考虑选择适合的实现方式。
 * </pre>
 */
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
