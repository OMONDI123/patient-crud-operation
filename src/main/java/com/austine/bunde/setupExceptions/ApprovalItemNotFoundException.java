package com.austine.bunde.setupExceptions;
/**
 * @author Austine Bunde
 *
 * Backend Java Developer
 */

public class ApprovalItemNotFoundException extends Exception {
    private static final long serialVersionUID = -5108708319397349950L;

    public ApprovalItemNotFoundException(String message) {
        super(message);
    }
}

