package com.sistemadecadastro.controller;

import com.sistemadecadastro.dto.Specialties.CreateSpecialtiesDto;
import com.sistemadecadastro.dto.Specialties.SpecialtiesDto;
import com.sistemadecadastro.dto.Specialties.UpdateSpecialtiesDto;
import com.sistemadecadastro.exception.Specialties.SpecialtiesException;
import com.sistemadecadastro.exception.Specialties.SpecialtiesNotFoundException;
import com.sistemadecadastro.service.SpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/medicinal")
public class SpecialtiesController {

    @Autowired
    private SpecialtiesService service;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Long> save(@Valid @RequestBody CreateSpecialtiesDto dto) throws Exception {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtiesDto> findById(@PathVariable long id) throws SpecialtiesNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@Valid @PathVariable long id, @RequestBody UpdateSpecialtiesDto dto) throws SpecialtiesException {
        service.update(id, dto);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> remove(@Valid @PathVariable long id) throws SpecialtiesNotFoundException {
        service.remove(id);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<SpecialtiesDto>> all() {
        return ResponseEntity.ok(service.allObjects());
    }

}