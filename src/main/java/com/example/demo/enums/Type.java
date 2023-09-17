package com.example.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    TEXT(0),
    IMAGE(1);

    private final int type;

    private static final Map<Integer, Type> BY_TYPE = new HashMap<>();

    static {
        for (Type t : values()){
            BY_TYPE.put(t.type, t);
        }
    }
    Type(int type) {
        this.type = type;
    }

    public int getType(){
        return type;
    }

    public static Type valueOfType(int type){return BY_TYPE.get(type);}

}
