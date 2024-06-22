package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.ShoppingCart;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart {
    public static final String PRODUCT_DOES_NOT_EXIST = "Product %s does not exist!";
    public static final String PRODUCT_DOES_NOT_EXIST_IN_SHOPPING_CART = "Shopping cart does not contain product with name %s!";

    private final List<Product> productList;

    public ShoppingCartImpl() {
        productList = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productList);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(String.format(PRODUCT_DOES_NOT_EXIST, product.getName()));
        }
        productList.add(product);
    }

    public void removeProduct(Product product) {
        if (!containsProduct(product)) {
            throw new IllegalArgumentException(String.format(PRODUCT_DOES_NOT_EXIST_IN_SHOPPING_CART, product.getName()));
        }
        productList.remove(product);
    }

    public boolean containsProduct(Product product) {
        ValidationHelpers.validateIsInputNull(product);
        return productList.contains(product);
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
