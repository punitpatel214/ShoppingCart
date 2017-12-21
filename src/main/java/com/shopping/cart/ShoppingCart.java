package com.shopping.cart;

import com.shopping.product.Product;
import com.shopping.util.MathUtil;

import java.util.*;

public class ShoppingCart {
    private Map<Long, CartProductDetail> productIdToCartProductDetailMap;
    private TaxCalculator taxCalculator;

    public ShoppingCart() {
        this.productIdToCartProductDetailMap = new HashMap<>();
        this.taxCalculator = new NoTaxCalculator();
    }

    public void setTaxCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void addProduct(Product product, int quantity) {
        CartProductDetail cartProductDetail = productIdToCartProductDetailMap.computeIfAbsent(product.getId(), productId -> new CartProductDetail(product));
        cartProductDetail.incrementQuantity(quantity);
    }

    public List<CartProductDetail> getCartProductDetails() {
        return new ArrayList<>(productIdToCartProductDetailMap.values());
    }

    public double totalPrice() {
        double totalAmount = totalAmount();
        return totalAmount + taxCalculator.calculateTax(totalAmount);
    }

    private double totalAmount() {
        return MathUtil.round(productIdToCartProductDetailMap.values().stream()
                .mapToDouble(CartProductDetail::totalProductPrice)
                .sum(), 2);
    }

    public double totalTax() {
        return taxCalculator.calculateTax(totalAmount());
    }
}
