package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;

public class CreamImpl extends ProductImpl implements Cream {
    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        this.scent = scent;
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
    public ScentType getScent() {
        return this.scent;
    }
}
