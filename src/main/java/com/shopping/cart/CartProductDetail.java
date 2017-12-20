package com.shopping.cart;

import com.shopping.product.Product;

public class CartProductDetail {
    private Product product;
    private int quantity;

    public CartProductDetail(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int productQuantity) {
        quantity += productQuantity;
    }

    public double totalProductPrice() {
        return product.getPrice() * quantity;
    }
}
