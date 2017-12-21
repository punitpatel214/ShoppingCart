package com.shopping.cart;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleTaxCalculatorTest {

    @Test
    public void calculateTax() throws Exception {
        SimpleTaxCalculator simpleTaxCalculator = new SimpleTaxCalculator(12.5);
        assertThat(simpleTaxCalculator.calculateTax(279.96), is(35.00));
    }

}