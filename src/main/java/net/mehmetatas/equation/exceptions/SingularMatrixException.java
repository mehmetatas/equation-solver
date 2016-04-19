package net.mehmetatas.equation.exceptions;

public class SingularMatrixException extends RuntimeException {
    public SingularMatrixException() {
        super("Coefficient matrix is singular or nearly singular");
    }
}
