package net.mehmetatas.equation;

import net.mehmetatas.equation.exceptions.InvalidEquationSystemException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mehmet on 19.04.2016.
 */
public class EquationSystemTest {
    @Test(expected = InvalidEquationSystemException.class)
    public void constructorShouldThrowException_IfNumberOfEquationsDoNotMatchLevel() {
        EquationSystem.create(
                1d, 1d, 2d, 3d,
                4d, 5d, 6d, 7d);
    }

    @Test(expected = InvalidEquationSystemException.class)
    public void constructorShouldThrowException_IfOneOfEquationsHasDifferentLevel() {
        EquationSystem.create(
                1d, 1d, 2d, 3d,
                4d, 5d, 7d, // 6 is missing
                8d, 9d, 10d, 11d);
    }

    @Test
    public void systemLevelShouldBeEqualToEquationCountAndLevel() {
        EquationSystem system = EquationSystem.create(
                1d, 1d, 2d, 3d,
                4d, 5d, 6d, 7d,
                8d, 9d, 10d, 11d);

        assertEquals(3, system.getLevel());
    }
}