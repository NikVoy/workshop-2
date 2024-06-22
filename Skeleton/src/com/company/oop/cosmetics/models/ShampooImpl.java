package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl extends ProductImpl implements Shampoo {
    public static final String MILLILITERS_CANNOT_BE_NEGATIVE = "Milliliters cannot be negative!";


    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        this.usageType = everyDay;
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
    public int getMillilitres() {
        return this.milliliters;
    }

    public void setMilliliters(int milliliters) {
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
