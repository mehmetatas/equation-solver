package net.mehmetatas.equation;

import net.mehmetatas.equation.exceptions.InvalidEquationSystemException;

import java.util.Arrays;

/**
 * Created by mehmet on 19.04.2016.
 */
public class EquationSystem {
    private Equation[] equations;

    private EquationSystem(Equation[] equations) {
        this.equations = equations;
    }

    public Equation[] getEquations() {
        return equations;
    }

    public int getLevel() {
        return equations.length;
    }

    public static EquationSystem create(double... resultsAndCoefficients) {
        int level = (int) Math.floor(Math.sqrt(resultsAndCoefficients.length));

        if (resultsAndCoefficients.length != level * (level + 1)) {
            throw new InvalidEquationSystemException();
        }

        Equation[] equations = new Equation[level];

        int equationIndex = 0;

        for (int i = 0; i < resultsAndCoefficients.length; i += level + 1) {

            double result = resultsAndCoefficients[i];
            double[] coefficients = new double[level];

            for (int j = 0; j < level; j++) {
                coefficients[j] = resultsAndCoefficients[i + 1 + j];
            }

            equations[equationIndex++] = new Equation(result, coefficients);
        }

        return new EquationSystem(equations);
    }
}
