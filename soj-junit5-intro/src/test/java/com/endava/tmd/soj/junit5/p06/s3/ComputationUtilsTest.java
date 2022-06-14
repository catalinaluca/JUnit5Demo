package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource({"streamForSumTests"})
    void testWithParameters(int a, int b, int result) {
        // JUnitSoftAssertions Assertion;
        assertEquals(result,sum(a, b));
    }

    static Stream streamForSumTests(){
        return Stream.of(arguments(0,0,0),
                arguments(1,2,3),
                arguments( 0,1,1),
                arguments(0,-1,-1),
                arguments(-2,-1,-3),
                arguments(-2,1,-1),
                arguments(2,-1,1),
                arguments(0,Integer.MAX_VALUE,Integer.MAX_VALUE),
                arguments( 0,Integer.MIN_VALUE,Integer.MIN_VALUE),
                arguments(Integer.MAX_VALUE,Integer.MIN_VALUE,-1));
    }
    @ParameterizedTest(name = "{0} + {1} = Overflow")
    @MethodSource("streamForExceptionTests")
    void exceptionWhenSumHasOverflow(int a, int b) {
        ArithmeticException exception=assertThrows(ArithmeticException.class,()->sum(a, b));
        assertEquals("Overflow while computing the sum",exception.getMessage());
    }

    static Stream streamForExceptionTests(){
        return Stream.of(arguments(Integer.MIN_VALUE,-1),
                arguments(Integer.MAX_VALUE,1));
    }
}
