package com.sistemadecadastro.exception.Doctor;

import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
public class DoctorInvalidException extends DoctorException {

	private static final long serialVersionUID = 1L;

	public DoctorInvalidException(String message) {
        super(message);
    }

    public DoctorInvalidException(String message, LocalDateTime timeStamp) {
        super(message, timeStamp);
    }
    
}
