package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl extends ProductImpl implements Cream {
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 15;
    public static final int BRAND_NAME_MIN_LENGTH = 3;
    public static final int BRAND_NAME_MAX_LENGTH = 15;

    private final ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        this.scent = scent;
    }

    @Override
    public ScentType getScent() {
        return this.scent;
    }

    @Override
    protected void validateName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
    }

    @Override
    protected void validateBrandName(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH,
                BRAND_NAME_MAX_LENGTH, "Brand name");
    }

    @Override
    protected void validatePrice(double price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(ProductImpl.INVALID_PRICE);
        }
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();

        result.append(super.print())
                .append(System.lineSeparator())
                .append(String.format(" #Scent: %s", getScent()))
                .append(System.lineSeparator())
                .append(" ===");

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreamImpl cream = (CreamImpl) o;
        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                getGenderType().equals(cream.getGenderType()) &&
                getScent().equals(cream.getScent());
    }

}
