
package com.akqa.trials;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PrimeNumberValidatorTest {
    private Integer primeNumber;
    private Boolean expectedValidation;
    private PrimeNumberValidator primeNumberValidator;

    @Before
    public void initialize() {
        primeNumberValidator = new PrimeNumberValidator();
    }

    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments from parameters we defined
    public PrimeNumberValidatorTest(Integer primeNumber, Boolean expectedValidation) {
        this.primeNumber = primeNumber;
        this.expectedValidation = expectedValidation;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] { { 2, true }, { 6, false }, { 19, true }, { 22, false } });
    }

    // This test will run 4 times since we have 4 parameters defined
    @Test
    public void testPrimeNumberValidator() {
        assertEquals(expectedValidation, primeNumberValidator.validate(primeNumber));
    }
}
