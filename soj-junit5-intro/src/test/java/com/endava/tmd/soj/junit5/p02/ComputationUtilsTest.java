package com.endava.tmd.soj.junit5.p02;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p02.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {
    @DisplayName("0+0=0")
    @Test
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
    void zeroShouldNotChangePositive() {
        assertThat(sum(0, 5)).isEqualTo(5);
    }
    @DisplayName("0+(-5)=-5")
    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -5)).isEqualTo(-5);
    }
    @DisplayName("2+5=7")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(2, 5)).isEqualTo(7);
    }
    @DisplayName("(-2)+(-5)=-7")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-2, -5)).isEqualTo(-7);
    }
    @DisplayName("(-2)+5=3")
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-2, 5)).isEqualTo(3);
    }
    @DisplayName("2+(-5)=-3")
    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -5)).isEqualTo(-3);
    }

}
