package org.knt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalcTest {
    @Test
    void testAdd() {
        Calc calc = new Calc();
        assertEquals(4, calc.add(2, 2));
        assertEquals(0, calc.add(0, 0)); 
        assertEquals(-2, calc.add(-1, -1));
    }

    @Test 
    void testSubtract() {
        Calc calc = new Calc();
        assertEquals(0, calc.subtract(2, 2));
        assertEquals(5, calc.subtract(10, 5));
        assertEquals(-1, calc.subtract(1, 2));
    }

    @Test
    void testMultiply() {
        Calc calc = new Calc();
        assertEquals(4, calc.multiply(2, 2));
        assertEquals(0, calc.multiply(0, 5));
        assertEquals(-6, calc.multiply(2, -3));
    }

    @Test
    void testDivide() {
        Calc calc = new Calc();
        assertEquals(2, calc.divide(4, 2));
        assertEquals(0, calc.divide(0, 5));
        assertEquals(-2, calc.divide(6, -3));
    }
} 