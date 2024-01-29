package org.example.service;

import org.example.exception.DivideZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> parameterizedCheckPlus() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(-5, -5, -10)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterizedCheckPlus")
    public void checkPlus(int a, int b, int expected) {
        int actual = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> parameterizedCheckMinus() {
        return Stream.of(
                Arguments.of(5, 5, 0),
                Arguments.of(-5, -5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterizedCheckMinus")
    public void checkMinus(int a, int b, int expected) {
        int actual = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> parameterizedCheckMultiply() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(-5, -5, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterizedCheckMultiply")
    public void checkMultiply(int a, int b, int expected) {
        int actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> parameterizedCheckDivide() {
        return Stream.of(
                Arguments.of(5, 5, 1),
                Arguments.of(-5, -5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterizedCheckDivide")
    public void checkDivide(int a, int b, int expected) {
        int actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> parameterizedCheckDivideByZero() {
        return Stream.of(
                Arguments.of(5, 0),
                Arguments.of(-5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterizedCheckDivideByZero")
    public void checkDivideByZero(int a, int b) {
        Assertions.assertThrows(DivideZeroException.class,
                () -> calculatorService.divide(a, b));
    }

}
