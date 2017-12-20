package com.shopping.cart;

import com.shopping.product.Product;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ShoppingCartStepDef {

    private ShoppingCart shoppingCart;
    private AtomicInteger productId;
    private Map<String, Product> productMap;

    public ShoppingCartStepDef() {
        this.productId = new AtomicInteger(101);
        this.productMap = new HashMap<>();
    }

    @Given("^empty Shopping Cart$")
    public void emptyShoppingCart() throws Throwable {
        this.shoppingCart = new ShoppingCart();
    }

    @And("^a Product, \"([^\"]*)\" with unit Price \"([^\"]*)\"$")
    public void aProductWithUnitPrice(String productName, double price) throws Throwable {
        productMap.putIfAbsent(productName, new Product(productId.incrementAndGet(), productName, price));
    }


    @When("^The user adds (\\d+) \"([^\"]*)\" to the shopping cart$")
    public void theUserAddsToTheShoppingCart(int quantity, String productName) throws Throwable {
        Product product = productMap.get(productName);
        assertThat(product, is(notNullValue()));
        shoppingCart.addProduct(product, quantity);
    }

    @Then("^The shopping cart should contain (\\d+) \"([^\"]*)\" each with a unit price of \"([^\"]*)\"$")
    public void theShoppingCartShouldContainEachWithAUnitPriceOf(int quantity, String productName, double price) throws Throwable {
        Optional<CartProductDetail> cartProductDetailOptional = shoppingCart.getCartProductDetails().stream()
                .filter(cartProductDetail -> cartProductDetail.getProduct().getName().equals(productName))
                .findAny();
        assertThat(cartProductDetailOptional.isPresent(), is(true));
        cartProductDetailOptional.ifPresent(cartProductDetail -> {
            assertThat(cartProductDetail.getQuantity(), is(quantity));
            assertThat(cartProductDetail.getProduct().getPrice(), is(price));
        });
    }

    @And("^the shopping cart’s total price should equal \"([^\"]*)\"$")
    public void theShoppingCartSTotalPriceShouldEqual(double totalPrice) throws Throwable {
        assertThat(shoppingCart.totalPrice(), is(totalPrice));
    }
}
