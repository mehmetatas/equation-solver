package net.mehmetatas.equation;

import net.mehmetatas.equation.Equation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquationTests {
    @Test
    public void levelEqualsCoefficientsLength() {
        Equation eq = new Equation(0d, new double[]{1d, 2d, 3d});

        assertEquals(4, eq.getLevel());
    }
}