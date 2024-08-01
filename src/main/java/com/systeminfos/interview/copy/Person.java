package com.systeminfos.interview.copy;

public class Person implements Cloneable {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
