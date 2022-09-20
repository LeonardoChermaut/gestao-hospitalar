package com.sistemadecadastro.service;

import com.sistemadecadastro.dto.SpecsDoctor.CreateSpecsDto;
import com.sistemadecadastro.dto.SpecsDoctor.SpecsDto;
import com.sistemadecadastro.dto.SpecsDoctor.UpdateSpecsDto;
import com.sistemadecadastro.model.SpecsDoctorModel;
import com.sistemadecadastro.repository.DoctorRepository;
import com.sistemadecadastro.repository.SpecialtiesRepository;
import com.sistemadecadastro.repository.SpecsDoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecsDoctorService {


    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private SpecsDoctorRepository repository;

    @Autowired
    private SpecialtiesRepository specialtiesRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    @Transactional
    public Long save(CreateSpecsDto dto) throws Exception {
        SpecsDoctorModel model = mapper.map(dto, SpecsDoctorModel.class);
        return repository.save(model).getId();
    }

    @Transactional
    public void update(long id, UpdateSpecsDto dto)throws Exception{
        SpecsDoctorModel model = this.repository.findById(id).orElseThrow(Exception::new);
        model.setEspecialidade(this.specialtiesRepository.findById(dto.getEspecialidade()).get());
        model.setMedico(this.doctorRepository.findById(dto.getMedico()).get());
        repository.save(model);
    }

    @Transactional
    public void remove(long id) throws Exception {
        objectOrThrow(id);
        repository.deleteById(id);
    }

    @Transactional
    public List<SpecsDto> allSpecs() {
        return repository.findAll().stream().map(model -> mapper.map(model, SpecsDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public SpecsDto findById(long id) throws Exception {
        return objectOrThrow(id);
    }

    @Transactional
    SpecsDto objectOrThrow(long id) throws Exception {
        return repository.findById(id).map(model -> mapper.map(model, SpecsDto.class))
                .orElseThrow(Exception::new);
    }

}
