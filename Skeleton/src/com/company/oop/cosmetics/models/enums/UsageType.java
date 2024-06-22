package com.company.oop.cosmetics.models.enums;

public enum UsageType {
    EVERY_DAY,
    MEDICAL;

    @Override
    public String toString() {
        switch (this) {
            case EVERY_DAY:
                return "EveryDay";
            case MEDICAL:
                return "Medical";
            default:
                throw new IllegalArgumentException();
        }
    }
}
