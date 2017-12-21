package com.shopping.cart;

public class NoTaxCalculator implements TaxCalculator {

    @Override
    public double calculateTax(double amount) {
        return 0;
    }
}
