package com.shopping.cart;

import com.shopping.util.MathUtil;

public class SimpleTaxCalculator implements TaxCalculator {
    private double taxRate;

    public SimpleTaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double calculateTax(double amount) {
        return MathUtil.round((amount * taxRate)/100, 2);
    }
}
