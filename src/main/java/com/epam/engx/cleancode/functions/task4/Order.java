package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {
        return getOrderPrice(getAvailableProducts());
    }

    private List<Product> getAvailableProducts() {
        List<Product> availableProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.isAvailable()) {
                availableProducts.add(product);
            }
        }
        return availableProducts;
    }

    private Double getOrderPrice(List<Product> availableProducts) {
        double orderPrice = 0.0;
        for (Product availableProduct : availableProducts) {
            orderPrice += availableProduct.getProductPrice();
        }
        return orderPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
