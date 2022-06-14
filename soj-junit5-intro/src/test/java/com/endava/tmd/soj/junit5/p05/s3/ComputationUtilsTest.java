package com.endava.tmd.soj.junit5.p05.s3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {
    @Test
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
        // assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
//        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
//        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
    @Test
    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        ArithmeticException exception=assertThrows(ArithmeticException.class,()->sum(-2147483648, -1));
        assertEquals("Overflow while computing the sum",exception.getMessage());
    }
    @DisplayName("0+0=0")
    @Test
    @Order(1)
    void zeroShouldNotChangeZero() {
        // JUnitSoftAssertions Assertion;
        assertEquals(0, sum(0, 0));

        //  AssertJ Assertion;
        assertThat(sum(0, 0)).isZero();

        //gresit
        //assertEquals(4, sum(0, 0));
    }
    @DisplayName("0+5=5")
    @Test
    @Order(2)
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 5)).isEqualTo(5);
    }
    @DisplayName("0+(-5)=-5")
    @Test
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -5)).isEqualTo(-5);
    }
    @DisplayName("2+5=7")
    @Test
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 5)).isEqualTo(7);
    }
    @DisplayName("(-2)+(-5)=-7")
    @Test
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -5)).isEqualTo(-7);
    }
    @DisplayName("(-2)+5=3")
    @Test
    @Order(6)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 5)).isEqualTo(3);
    }
    @DisplayName("2+(-5)=-3")
    @Test
    @Order(7)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -5)).isEqualTo(-3);
    }
    @DisplayName("0+MAX_INT=MAX_INT")
    @Test
    @Order(8)
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(0,Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }
    @DisplayName("(-5)+MAX_INT=MAX_INT-5")
    @Test
    @Order(9)
    void maxIntAndANegativeNumber() {
        assertThat(sum(-5,Integer.MAX_VALUE)).isEqualTo(2147483642);
    }
    @DisplayName("0+MIN_INT=MIN_INT")
    @Test
    @Order(10)
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(0,Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
    @DisplayName("5+MIN_INT=5-MIN_INT")
    @Test
    @Order(11)
    void minIntAndAPositiveNumber() {
        assertThat(sum(5,Integer.MIN_VALUE)).isEqualTo(-2147483643);
    }
    @DisplayName("MAX_INT+MIN_INT=0")
    @Test
    @Order(12)
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MAX_VALUE,Integer.MIN_VALUE)).isEqualTo(-1);
    }
    @Test
    @Order(13)
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE,2)).isEqualTo(2147483649L);
    }

}
