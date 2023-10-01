package com.eduford.www.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
    ADMIN(0),
    STUDENT(1);
    private final int userType;

    private static final Map<Integer, UserType> BY_USER_TYPE = new HashMap<>();

    static {
        for (UserType t : values()){
            BY_USER_TYPE.put(t.userType, t);
        }
    }
    UserType(int userType) {
        this.userType = userType;
    }

    public int getUserType(){
        return userType;
    }

    public static UserType valueOfUserType(int userType){return BY_USER_TYPE.get(userType);}
}
