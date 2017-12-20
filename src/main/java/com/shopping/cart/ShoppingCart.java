package com.shopping.cart;

import com.shopping.product.Product;
import com.shopping.util.MathUtil;

import java.util.*;

public class ShoppingCart {
    private Map<Long, CartProductDetail> productIdToCartProductDetailMap;

    public ShoppingCart() {
        this.productIdToCartProductDetailMap = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        CartProductDetail cartProductDetail = productIdToCartProductDetailMap.computeIfAbsent(product.getId(), productId -> new CartProductDetail(product));
        cartProductDetail.incrementQuantity(quantity);
    }

    public List<CartProductDetail> getCartProductDetails() {
        return new ArrayList<>(productIdToCartProductDetailMap.values());
    }

    public double totalPrice() {
        return MathUtil.round(productIdToCartProductDetailMap.values().stream()
                .mapToDouble(CartProductDetail::totalProductPrice)
                .sum(), 2);
    }
}
