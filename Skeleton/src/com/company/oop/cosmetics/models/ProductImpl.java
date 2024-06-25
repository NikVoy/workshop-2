package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public abstract class ProductImpl implements Product {
    public static final String PRODUCT_CREATED = "%s with name %s was created!";
    public static final String PRODUCT_NAME_ALREADY_EXISTS = "%s with name %s already exists!";
    public static final String INVALID_PRICE = "Invalid value for price. Should be a number.";
    public static final String INVALID_MILLILITRES = "Invalid value for millilitres. Should be a number.";

    public static final double MIN_PRICE = 0;

    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    protected abstract void validateName(String name);

    @Override
    public String getBrandName() {
        return brand;
    }

    private void setBrand(String brand) {
        validateBrandName(brand);
        this.brand = brand;
    }

    protected abstract void validateBrandName(String brand);

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        validatePrice(price);

        this.price = price;
    }

    protected abstract void validatePrice(double price);

    @Override
    public GenderType getGenderType() {
        return gender;
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("#%s %s", this.name, this.brand))
                .append(System.lineSeparator())
                .append(String.format(" #Price: $%.2f", this.price))
                .append(System.lineSeparator())
                .append(String.format(" #Gender: %s", this.gender));

        return result.toString();
    }
}
