package net.mehmetatas.equation.solvers;

import net.mehmetatas.equation.EquationSolver;
import net.mehmetatas.equation.EquationSystem;
import net.mehmetatas.equation.exceptions.SingularMatrixException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GaussJordanEliminationSolverTest {
    @Test
    public void solve2x2() {
        EquationSolver solver = new GaussJordanEliminationSolver();
        double[] solutionVector = solver.solve(EquationSystem.create(
                14d, 1d, 2d,
                23d, 2d, 3d
        ));

        assertArrayEquals(new double[]{4d, 5d}, solutionVector, 1e-10);
    }

    @Test
    public void solve3x3() {
        EquationSolver solver = new GaussJordanEliminationSolver();
        double[] solutionVector = solver.solve(EquationSystem.create(
                10d, 1d, 2d, 3d,
                13d, 2d, 3d, 1d,
                13d, 3d, 1d, 2d
        ));

        assertArrayEquals(new double[]{3d, 2d, 1d}, solutionVector, 1e-10);
    }

    @Test
    public void solve4x4() {
        EquationSolver solver = new GaussJordanEliminationSolver();
        double[] solutionVector = solver.solve(EquationSystem.create(
                30d, 1d, 2d, 3d, 4d,
                24d, 2d, 3d, 4d, 1d,
                22d, 3d, 4d, 1d, 2d,
                24d, 4d, 1d, 2d, 3d
        ));

        assertArrayEquals(new double[]{1d, 2d, 3d, 4d}, solutionVector, 1e-10);
    }

    @Test
    public void solveWithZeroCoefficients() {
        EquationSolver solver = new GaussJordanEliminationSolver();
        double[] solutionVector = solver.solve(EquationSystem.create(
                5d, 1d, 2d, 0d,
                7d, 1d, 0d, 2d,
                8d, 0d, 1d, 2d
        ));
        assertArrayEquals(new double[]{1d, 2d, 3d}, solutionVector, 1e-10);
    }

    @Test(expected = SingularMatrixException.class)
    public void shouldThrowSingularMatrixException_IfAnyEquationIsMultipleOfOther() {
        EquationSolver solver = new GaussJordanEliminationSolver();
        double[] solutionVector = solver.solve(EquationSystem.create(
                30d, 1d, 2d, 3d, 4d,
                60d, 2d, 4d, 6d, 8d,
                22d, 3d, 4d, 1d, 2d,
                24d, 4d, 1d, 2d, 3d
        ));
        assertArrayEquals(new double[]{1d, 2d, 3d, 4d}, solutionVector, 1e-10);
    }

    @Test(expected = SingularMatrixException.class)
    public void shouldThrowSingularMatrixException_IfResultIsIncosistent() {
        EquationSolver solver = new GaussJordanEliminationSolver();
        double[] solutionVector = solver.solve(EquationSystem.create(
                6d, 1d, 1d, 1d,
                9d, 2d, 2d, 1d,
                10d, 3d, 3d, 1d // it is clear that result should be 12
        ));
        assertArrayEquals(new double[]{1d, 2d, 3d}, solutionVector, 1e-10);
    }
}