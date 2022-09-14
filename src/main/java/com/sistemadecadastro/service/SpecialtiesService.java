package com.sistemadecadastro.service;

import com.sistemadecadastro.dto.Specialties.CreateSpecialtiesDto;
import com.sistemadecadastro.dto.Specialties.SpecialtiesDto;
import com.sistemadecadastro.dto.Specialties.UpdateSpecialtiesDto;
import com.sistemadecadastro.exception.Doctor.DoctorNotFoundException;
import com.sistemadecadastro.exception.Specialties.SpecialtiesNotFoundException;
import com.sistemadecadastro.model.SpecialtiesModel;
import com.sistemadecadastro.repository.SpecialtiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtiesService {

	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private SpecialtiesRepository repository;


	@Transactional
	public Long save(CreateSpecialtiesDto dto) throws Exception {
		SpecialtiesModel model = mapper.map(dto, SpecialtiesModel.class);
		return repository.save(model).getId();
	}

	@Transactional
	public void update(long id, UpdateSpecialtiesDto dto) throws SpecialtiesNotFoundException {
		SpecialtiesModel model = this.repository.findById(id).orElseThrow(SpecialtiesNotFoundException::new);
		model.setNome(dto.getNome());
		repository.save(model);
	}

	@Transactional
	public void remove(long id) throws SpecialtiesNotFoundException {
		objectOrThrow(id);
		repository.deleteById(id);
	}

	@Transactional
	public List<SpecialtiesDto> allObjects() {
		return repository.findAll().stream().map(model -> mapper.map(model, SpecialtiesDto.class))
				.collect(Collectors.toList());
	}

	@Transactional
	public SpecialtiesDto findById(long id) throws SpecialtiesNotFoundException{
		return objectOrThrow(id);
	}

	@Transactional
	SpecialtiesDto objectOrThrow(long id) throws SpecialtiesNotFoundException {
		return repository.findById(id).map(model -> mapper.map(model, SpecialtiesDto.class))
				.orElseThrow(SpecialtiesNotFoundException::new);
	}


}