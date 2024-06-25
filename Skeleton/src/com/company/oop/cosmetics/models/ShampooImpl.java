package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ShampooImpl extends ProductImpl implements Shampoo {
    public static final String MILLILITERS_CANNOT_BE_NEGATIVE = "Milliliters cannot be negative!";

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;

    private int milliliters;
    private final UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usageType) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }

    @Override
    public int getMillilitres() {
        return this.milliliters;
    }

    private void setMilliliters(int milliliters) {
        if (milliliters < 0) {
            throw new IllegalArgumentException(MILLILITERS_CANNOT_BE_NEGATIVE);
        }
        this.milliliters = milliliters;
    }

    @Override
    public UsageType getUsageType() {
        return this.usageType;
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
                .append(String.format(" #Milliliters: %s", this.milliliters))
                .append(System.lineSeparator())
                .append(String.format(" #Usage: %s", this.usageType))
                .append(System.lineSeparator())
                .append(" ===");

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
}
