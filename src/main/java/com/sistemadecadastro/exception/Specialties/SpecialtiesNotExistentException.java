package com.sistemadecadastro.exception.Specialties;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
public class SpecialtiesNotExistentException extends SpecialtiesException {

    private static final long serialVersionUID = 1L;

    public SpecialtiesNotExistentException(String message) {
        super(message);
    }

    public SpecialtiesNotExistentException(String message, LocalDateTime timeStamp) {
        super(message, timeStamp);
    }

}
