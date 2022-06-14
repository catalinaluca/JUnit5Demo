package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p03.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
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

}