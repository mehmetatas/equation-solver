package net.mehmetatas.equation.solvers;

import net.mehmetatas.equation.Equation;
import net.mehmetatas.equation.EquationSolver;
import net.mehmetatas.equation.EquationSystem;
import net.mehmetatas.equation.exceptions.SingularMatrixException;
import org.springframework.stereotype.Component;

/**
 * Created by mehmet on 19.04.2016.
 */
@Component
public class GaussJordanEliminationSolver implements EquationSolver {
    private final static double EPSILON = 1e-10;

    @Override
    public double[] solve(EquationSystem system) {
        int level = system.getLevel();

        double[][] coefficientMatrix = new double[level][];
        double[] resultVector = new double[level];

        Equation[] equations = system.getEquations();

        for (int i = 0; i < level; i++) {
            coefficientMatrix[i] = equations[i].getCoefficients();
            resultVector[i] = equations[i].getResult();
        }

        return solve(coefficientMatrix, resultVector, level);
    }

    private static double[] solve(double[][] coefficientMatrix, double[] resultVector, int level) {
        for (int p = 0; p < level; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < level; i++) {
                if (Math.abs(coefficientMatrix[i][p]) > Math.abs(coefficientMatrix[max][p])) {
                    max = i;
                }
            }

            double[] temp = coefficientMatrix[p];
            coefficientMatrix[p] = coefficientMatrix[max];
            coefficientMatrix[max] = temp;

            double t = resultVector[p];
            resultVector[p] = resultVector[max];
            resultVector[max] = t;

            // singular or nearly singular
            if (Math.abs(coefficientMatrix[p][p]) <= EPSILON) {
                throw new SingularMatrixException();
            }

            // pivot within coefficientMatrix and results
            for (int i = p + 1; i < level; i++) {
                double alpha = coefficientMatrix[i][p] / coefficientMatrix[p][p];
                resultVector[i] -= alpha * resultVector[p];
                for (int j = p; j < level; j++) {
                    coefficientMatrix[i][j] -= alpha * coefficientMatrix[p][j];
                }
            }
        }

        // back substitution
        double[] solutionVector = new double[level];
        for (int i = level - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < level; j++) {
                sum += coefficientMatrix[i][j] * solutionVector[j];
            }
            solutionVector[i] = (resultVector[i] - sum) / coefficientMatrix[i][i];
        }

        return solutionVector;
    }
}
