package net.mehmetatas.equation.exceptions;

/**
 * Created by mehmet on 19.04.2016.
 */
public class InvalidEquationSystemException extends RuntimeException {
    public InvalidEquationSystemException() {
        super("Invalid system! All equations must be at same level and number of equations must be equal to this level.");
    }
}
