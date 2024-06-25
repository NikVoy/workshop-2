package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    private static final int CATEGORY_NAME_MIN_LENGTH = 2;
    private static final int CATEGORY_NAME_MAX_LENGTH = 15;
    public static final String CATEGORY_NAME = "Category name";
    public static final String CANNOT_ADD_PRODUCT_WHICH_IS_NULL = "Cannot add product which is null!";
    public static final String PRODUCT_IS_NOT_FOUND = "Product is not found!";

    private String name;
    private final List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name, CATEGORY_NAME_MIN_LENGTH, CATEGORY_NAME_MAX_LENGTH, CATEGORY_NAME);
        this.name = name;
    }

    public List<Product> getProducts() {
        //Because otherwise we will give direct access to original collection and could be modified
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        ValidationHelpers.validateIsInputNull(product);
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        if (!this.products.contains(product)) {
            throw new IllegalArgumentException(PRODUCT_IS_NOT_FOUND);
        }

        this.products.remove(product);
    }

    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("#Category: %s", this.name))
                .append(System.lineSeparator());

        if (products.isEmpty()) {
            result.append(" #No product in this category");
        } else {
            for (Product product : products) {
                result.append(product.print());
            }
        }

        return result.toString();
    }
}
