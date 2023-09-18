package com.example.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus {
    INACTIVE(0),
    ACTIVE(1),
    SUSPENDED(2),
    DEACTIVATED(3);

    private final int userStatus;

    private static final Map<Integer, UserStatus> BY_USER_STATUS = new HashMap<>();

    static {
        for (UserStatus us : values()){
            BY_USER_STATUS.put(us.userStatus, us);
        }
    }
    UserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getUserStatus(){
        return userStatus;
    }

    public static UserStatus valueOfUserStatus(int userStatus){return BY_USER_STATUS.get(userStatus);}

}
