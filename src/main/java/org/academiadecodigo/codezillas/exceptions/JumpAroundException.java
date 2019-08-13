package org.academiadecodigo.codezillas.exceptions;

/**
 * A generic java bank exception to be used as base for concrete types of exceptions
 *
 * @see Exception
 */
public class JumpAroundException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public JumpAroundException(String message) {
        super(message);
    }
}
