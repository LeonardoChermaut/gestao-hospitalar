package com.sistemadecadastro.controller;

import com.sistemadecadastro.exception.Doctor.DoctorException;
import com.sistemadecadastro.exception.Doctor.DoctorInvalidException;
import com.sistemadecadastro.exception.Doctor.DoctorNotExistentException;
import com.sistemadecadastro.exception.Doctor.DoctorNotFoundException;
import com.sistemadecadastro.exception.Specialties.SpecialtiesException;
import com.sistemadecadastro.exception.Specialties.SpecialtiesNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
 public class ExceptionController extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value = DoctorException.class)
        public ResponseEntity<Object> handleUserException(
            Exception ex, WebRequest request) {
            String bodyOfResponse = "Verifique os parametros passados. " + (ex.getMessage() == null ? "" : ex.getMessage());
            return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }


    @ExceptionHandler(value = DoctorInvalidException.class)
    public ResponseEntity<Object> handleUserInvalidoException(
           Exception ex, WebRequest request) {
        String bodyOfResponse = "User inválido, verifique as informações e tente novamente. " + (ex.getMessage() == null ? "" : ex.getMessage());        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(value = DoctorNotFoundException.class)
    public ResponseEntity<Object> handleUserNaoEncontradoException(
           Exception ex, WebRequest request) {
        String bodyOfResponse = "User não encontrado. Verifique as informações e tente novamente. " + (ex.getMessage() == null ? "" : ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = DoctorNotExistentException.class)
    public ResponseEntity<Object> handleUserExistenteException(
            Exception ex, WebRequest request) {
        Object bodyOfResponse = "Email ou username já existentes, verifique outros. " + (ex.getMessage() == null ? "" : ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }


    @ExceptionHandler(value =  SpecialtiesException.class)
    public ResponseEntity<Object> handleEspecialidadeInvalidaException(
            Exception ex, WebRequest request) {
        String bodyOfResponse = "Especialidade inválida, verifique as informações e tente novamente. " + (ex.getMessage() == null ? "" : ex.getMessage());        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(value = SpecialtiesNotFoundException.class)
    public ResponseEntity<Object> handleEspecialidadeNaoEncontradaException(
            Exception ex, WebRequest request) {
        String bodyOfResponse = "Especialidade não encontrada. Verifique as informações e tente novamente. " + (ex.getMessage() == null ? "" : ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = SpecialtiesException.class)
    public ResponseEntity<Object> handleSpecialtiesExistenteException(
            Exception ex, WebRequest request) {
        Object bodyOfResponse = "Especialidade já existente, verifique outros. " + (ex.getMessage() == null ? "" : ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
