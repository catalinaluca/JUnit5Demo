package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p04.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
@DisplayName("Tests for my sum method")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
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
