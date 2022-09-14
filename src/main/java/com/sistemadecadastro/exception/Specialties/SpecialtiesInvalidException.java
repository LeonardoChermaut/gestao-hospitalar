package com.sistemadecadastro.exception.Specialties;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class SpecialtiesInvalidException extends SpecialtiesException {

	private static final long serialVersionUID = 1L;

	public SpecialtiesInvalidException(String message) {
        super(message);
    }

    public SpecialtiesInvalidException(String message, LocalDateTime timeStamp) {
        super(message, timeStamp);
    }
    
}
