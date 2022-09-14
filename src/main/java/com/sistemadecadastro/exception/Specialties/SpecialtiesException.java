package com.sistemadecadastro.exception.Specialties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class SpecialtiesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
    private LocalDateTime timeStamp;

    public SpecialtiesException(String message) {
        super(message);
        this.message = message;
    }

    public SpecialtiesException(String message, LocalDateTime timeStamp) {
        super(message);
        this.message = message;
        this.timeStamp = timeStamp;
    }

}
