package com.systeminfos.interview.copy;

/**
 * 深拷贝：拷贝对象和原始对象的引用类型引用不同的对象。
 */
public class Cat2 implements Cloneable {


    private String name;
    private Person owner;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        if (1 == 1 & 2 > 1) {

        }
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

        int a = 5; // 0101 in binary
        int b = 3; // 0011 in binary
        int result = a & b; // 0001 in binary, which is 1 in decimal
        System.out.println(result);

        boolean a1 = true;
        boolean b1 = false;
        if (a1 & b1) {
            // 这个块不会执行，因为 b 是 false
            System.out.println(22);
        }
        System.out.println(a1 & b1);
    }
    //output
    //程序员大彬
}