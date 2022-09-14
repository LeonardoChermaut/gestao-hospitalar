package com.sistemadecadastro.controller;

import com.sistemadecadastro.dto.Doctor.CreateDoctorDto;
import com.sistemadecadastro.dto.Doctor.UpdateDoctorDto;
import com.sistemadecadastro.dto.Doctor.DoctorDto;
import com.sistemadecadastro.exception.Doctor.DoctorException;
import com.sistemadecadastro.exception.Doctor.DoctorNotFoundException;
import com.sistemadecadastro.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Long> save(@Valid @RequestBody CreateDoctorDto dto) throws Exception {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> findById(@PathVariable long id) throws DoctorNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@Valid @PathVariable long id, @RequestBody UpdateDoctorDto dto) throws DoctorException {
        service.update(id, dto);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> remove(@Valid @PathVariable long id) throws DoctorNotFoundException {
        service.remove(id);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> all() {
        return ResponseEntity.ok(service.allObjects());
    }


}