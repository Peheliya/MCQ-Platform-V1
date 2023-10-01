package com.eduford.www.enums;

import java.util.HashMap;
import java.util.Map;

public enum DifficultyLevel {
    BEGINNER(0),
    INTERMEDIATE(1),
    ADVANCED(2);

    private final int level;

    private static final Map<Integer, DifficultyLevel> BY_LEVEL = new HashMap<>();

    static {
        for (DifficultyLevel d : values()) {
            BY_LEVEL.put(d.level, d);
        }
    }

    DifficultyLevel(int level) {
        this.level = level;
    }

    public int getLevel(){
        return level;
    }

    public static DifficultyLevel valueOfLevel(int level) {
        return BY_LEVEL.get(level);
    }
}
