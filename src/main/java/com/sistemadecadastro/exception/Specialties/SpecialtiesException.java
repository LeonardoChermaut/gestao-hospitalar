package com.sistemadecadastro.exception.Specialties;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class SpecialtiesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
    private LocalDateTime timeStamp;


}
