package com.akqa.trials;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestWithMatchersTest {

    private int value;
    private Matcher<?> expectedValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { 1, greaterThan(0) }, 
                { 0, not(greaterThan(1)) },
                { 2, allOf(greaterThan(1), lessThan(3)) }, 
                { 4, allOf(greaterThan(1), lessThan(3)) },
           });
    }

    public ParameterizedTestWithMatchersTest(int value, Matcher<?> expectedValue) {
        this.value = value;
        this.expectedValue = expectedValue;
    }

    @Test
    public void valueShouldMatchExpectations() {
        assertThat(describeExpectations(), expectedValue.matches(value), is(true));
    }

    private String describeExpectations() {
        return Integer.toString(value) + " should be " + expectedValue.toString();
    }
}
