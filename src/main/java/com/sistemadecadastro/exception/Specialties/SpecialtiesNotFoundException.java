package com.sistemadecadastro.exception.Specialties;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
public class SpecialtiesNotFoundException extends SpecialtiesException {

	private static final long serialVersionUID = 1L;

	public SpecialtiesNotFoundException(String message) {
        super(message);
    }

    public SpecialtiesNotFoundException(String message, LocalDateTime timeStamp) {
        super(message, timeStamp);
    }

}
