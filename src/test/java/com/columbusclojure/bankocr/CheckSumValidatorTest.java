package com.columbusclojure.bankocr;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CheckSumValidatorTest {
    
    @Test
    public void testCheckSumIsValid_true() {
        assertTrue(CheckSumValidator.isValid("345882865"));
        assertTrue(CheckSumValidator.isValid("000000051"));
        assertTrue(CheckSumValidator.isValid("123456789"));
        assertTrue(CheckSumValidator.isValid("000000000"));
    }

    @Test
    public void testCheckSumIsValid_false() {
        assertFalse(CheckSumValidator.isValid("123456389"));
        assertFalse(CheckSumValidator.isValid("722466035"));
    }
}