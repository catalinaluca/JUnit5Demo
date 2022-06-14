package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p03.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@DisplayName("Tests for my sum method")
@TestMethodOrder(MethodOrderer.MethodName.class)
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

