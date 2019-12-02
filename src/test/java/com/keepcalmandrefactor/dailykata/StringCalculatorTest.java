package com.keepcalmandrefactor.dailykata;

import java.util.AbstractCollection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator sc;

    @Before
    public void setUp() throws Exception {
        sc = new StringCalculator();
    }

    @Test
    public void emptyStringReturns0() {
        assertEquals(0, sc.add(""));
    }

    @Test
    public void oneReturns1() {
        assertEquals(1, sc.add("1"));
    }

    @Test
    public void tenReturns10() {
        assertEquals(10, sc.add("10"));
    }

    @Test
    public void twoNumbersSeparatedByCommaReturnsSum() {
        assertEquals(5, sc.add("2,3"));
    }

    @Test
    public void twoNumbersNewlineDelimitedReturnSum() {
        assertEquals(15, sc.add("7" + System.lineSeparator() + "8"));
    }

    @Test
    public void threeNumbersDelimitedWithCommasAndNewlinesReturnSum() {
        assertEquals(17, sc.add("3,9" + System.lineSeparator() + "5"));
    }

    @Test
    public void negativeNumbersThrowExceptionListingNegativeNumbers() {
        try {
            sc.add("-1,2,-3");
            fail();
        } catch (NumberFormatException e) {
            assertEquals("negatives not allowed: -1,-3", e.getMessage());
        }
    }
}