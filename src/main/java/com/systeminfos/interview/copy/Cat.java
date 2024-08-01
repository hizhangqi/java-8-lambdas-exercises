package com.systeminfos.interview.copy;

/**
 * 浅拷贝：拷⻉对象和原始对象的引⽤类型引用同⼀个对象。
 * <p>
 * https://topjavaer.cn/java/java-basic.html#什么是stringjoiner
 */
public class Cat implements Cloneable {
    private String name;
    private Person owner;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Cat c = new Cat();
        Person p = new Person(18, "程序员大彬");
        c.owner = p;

        Cat cloneCat = (Cat) c.clone();
        p.setName("大彬");
        System.out.println(cloneCat.owner.getName());
    }
    //output
    //大彬
}