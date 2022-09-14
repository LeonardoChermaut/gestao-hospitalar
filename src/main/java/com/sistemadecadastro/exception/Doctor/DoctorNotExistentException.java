package com.sistemadecadastro.exception.Doctor;

import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@NoArgsConstructor
public class DoctorNotExistentException extends DoctorException {

    private static final long serialVersionUID = 1L;

    public DoctorNotExistentException(String message) {
        super(message);
    }

    public DoctorNotExistentException(String message, LocalDateTime timeStamp) {
        super(message, timeStamp);
    }

}
