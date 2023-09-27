package com.austine.bunde.setupExceptions;

public class PatientNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5108708319397349950L;

	public PatientNotFoundException(String message) {
        super(message);
    }

}
