package com.sistemadecadastro.controller;

import com.sistemadecadastro.dto.SpecsDoctor.CreateSpecsDto;
import com.sistemadecadastro.dto.SpecsDoctor.SpecsDto;
import com.sistemadecadastro.dto.SpecsDoctor.UpdateSpecsDto;
import com.sistemadecadastro.service.SpecsDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/specsdoctor")
public class SpecsDoctorController {


    @Autowired
    private SpecsDoctorService service;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Long> save(@Valid @RequestBody CreateSpecsDto dto) throws Exception {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecsDto> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@Valid @PathVariable long id, @RequestBody UpdateSpecsDto dto) throws Exception {
        service.update(id, dto);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> remove(@Valid @PathVariable long id) throws Exception {
        service.remove(id);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<SpecsDto>> all() {
        return ResponseEntity.ok(service.allSpecs());
    }

}
