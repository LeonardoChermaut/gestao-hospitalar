package com.sistemadecadastro.exception.Doctor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class DoctorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
    private LocalDateTime timeStamp;

    public DoctorException(String message) {
        super(message);
        this.message = message;
    }

    public DoctorException(String message, LocalDateTime timeStamp) {
        super(message);
        this.message = message;
        this.timeStamp = timeStamp;
    }

}
