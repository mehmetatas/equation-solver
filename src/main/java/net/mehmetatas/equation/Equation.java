package net.mehmetatas.equation;

public class Equation {
    private double result;
    private double[] coefficients;

    public Equation(double result, double[] coefficients) {
        this.result = result;
        this.coefficients = coefficients;
    }

    public double getResult() {
        return result;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public int getLevel() {
        return coefficients.length;
    }
}
