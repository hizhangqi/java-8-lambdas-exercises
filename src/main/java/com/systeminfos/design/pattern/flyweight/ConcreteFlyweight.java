package com.systeminfos.design.pattern.flyweight;

class ConcreteFlyweight implements Flyweight {
    private String internalState;
    
    public ConcreteFlyweight(String internalState) {
        this.internalState = internalState;
    }
    
    @Override
    public void operation(String externalState) {
        System.out.println("Internal state: " + internalState);
        System.out.println("External state: " + externalState);
    }
}