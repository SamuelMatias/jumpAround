package org.academiadecodigo.codezillas.exceptions;

import org.academiadecodigo.codezillas.errors.ErrorMessage;

/**
 * Thrown to indicate that the customer was not found
 */
public class CustomerNotFoundException extends JumpAroundException {

    /**
     * @see JumpAroundException#JumpAroundException(String)
     */
    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND);
    }
}
