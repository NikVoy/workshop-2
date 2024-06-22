package com.company.oop.cosmetics.models.enums;

public enum GenderType {
    MEN,
    WOMEN,
    UNISEX;

    @Override
    public String toString() {
        switch (this) {
            case MEN:
                return "Men";
            case WOMEN:
                return "Women";
            case UNISEX:
                return "Unisex";
            default:
                throw new IllegalArgumentException();
        }
    }
}
