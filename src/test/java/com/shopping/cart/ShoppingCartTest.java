package com.shopping.cart;

import com.shopping.product.Product;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {

    @Test
    public void addProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(101, "Dove", 33.95);
        shoppingCart.addProduct(product, 5);
        CartProductDetail productDetail = getCartProductDetail(shoppingCart, product);
        assertThat(productDetail.getQuantity(), is(5));

        shoppingCart.addProduct(product, 10);
        productDetail = getCartProductDetail(shoppingCart, product);
        assertThat(productDetail.getQuantity(), is(15));
    }

    private CartProductDetail getCartProductDetail(ShoppingCart shoppingCart, Product product) {
        return shoppingCart.getCartProductDetails().stream()
                .filter(cartProductDetail -> cartProductDetail.getProduct().equals(product))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    @Test
    public void totalAmount() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product(101, "Dove", 39.99);
        shoppingCart.addProduct(product, 5);
        assertThat(shoppingCart.totalPrice(), is(199.95));
    }
}