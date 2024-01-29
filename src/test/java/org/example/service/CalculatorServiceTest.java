package org.example.service;

import org.example.exception.DivideZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void ResultOfPlus() {
        int a = 5;
        int b = 5;
        int expected = 10;
        int actual = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, actual);

        a = -5;
        b = -5;
        expected = -10;
        actual = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultOfMinus() {
        int a = 5;
        int b = 5;
        int expected = 0;
        int actual = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, actual);

        a = -5;
        b = -5;
        actual = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultOfMultiply() {
        int a = 5;
        int b = 5;
        int expected = 25;
        int actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);

        a = -5;
        b = -5;
        actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ResultOfDivide() {
        int a = 5;
        int b = 5;
        int expected = 1;
        int actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);

        a = -5;
        b = -5;
        actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void resultOfDivideByZero() {
        int a = 5;
        int b = 0;
        Assertions.assertThrows(DivideZeroException.class,
                () -> calculatorService.divide(a, b));
    }
}
