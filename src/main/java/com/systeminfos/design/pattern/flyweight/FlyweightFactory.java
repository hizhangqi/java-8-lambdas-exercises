package com.systeminfos.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

class FlyweightFactory {
    private Map<String, Flyweight> flyweights;
    
    public FlyweightFactory() {
        flyweights = new HashMap<>();
    }
    
    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            return flyweights.get(key);
        } else {
            Flyweight flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
            return flyweight;
        }
    }
}