package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductImpl implements Toothpaste {
    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;

    private List<String> ingredients;

    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        this.ingredients = ingredients;
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(this.ingredients);
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
                .append(String.format(" #Ingredients: %s", getIngredients()))
                .append(System.lineSeparator())
                .append(" ===");

        return result.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}
