package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.endava.tmd.soj.junit5.p06.s2.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,0,0",
            "1,2,3",
            "0,1,1",
            "0,-1,-1",
            "-2,-1,-3",
            "-2,1,-1",
            "2,-1,1",
            "0,2147483647,2147483647",
            "0,-2147483648,-2147483648",
            "2147483647,-1,2147483646" ,
            "-2147483648,1,-2147483647",
            "2147483647,-2147483648,-1",
    })
    void testWithParameters(int a, int b, int result) {
        // JUnitSoftAssertions Assertion;
        assertEquals(result,sum(a, b));
    }
    @ParameterizedTest(name = "{0} + {1} = Overflow")
    @CsvSource({
            "-2147483648,-1",
            "2147483647,1"
    })
    void exceptionWhenSumHasOverflow(int a, int b) {
        ArithmeticException exception=assertThrows(ArithmeticException.class,()->sum(a, b));
        assertEquals("Overflow while computing the sum",exception.getMessage());
    }
}
