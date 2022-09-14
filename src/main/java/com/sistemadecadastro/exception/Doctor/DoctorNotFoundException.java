package com.sistemadecadastro.exception.Doctor;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
public class DoctorNotFoundException extends DoctorException {

	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException(String message) {
        super(message);
    }

    public DoctorNotFoundException(String message, LocalDateTime timeStamp) {
        super(message, timeStamp);
    }

}
