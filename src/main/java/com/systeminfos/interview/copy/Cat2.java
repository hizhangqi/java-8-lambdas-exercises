package com.systeminfos.interview.copy;

/**
 * 深拷贝：拷贝对象和原始对象的引用类型引用不同的对象。
 */
public class Cat2 implements Cloneable {
    private String name;
    private Person owner;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Cat2 c = null;
        c = (Cat2) super.clone();
        c.owner = (Person) owner.clone();//拷贝Person对象
        return c;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Cat2 c = new Cat2();
        Person p = new Person(18, "程序员大彬");
        c.owner = p;

        Cat2 cloneCat = (Cat2) c.clone();
        p.setName("大彬");
        System.out.println(cloneCat.owner.getName());
    }
    //output
    //程序员大彬
}