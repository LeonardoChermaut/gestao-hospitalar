package com.sistemadecadastro.service;

import com.sistemadecadastro.dto.Doctor.CreateDoctorDto;
import com.sistemadecadastro.dto.Doctor.UpdateDoctorDto;
import com.sistemadecadastro.dto.Doctor.DoctorDto;
import com.sistemadecadastro.exception.Doctor.DoctorNotFoundException;
import com.sistemadecadastro.model.DoctorModel;
import com.sistemadecadastro.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private DoctorRepository repository;


	@Transactional
	public Long save(CreateDoctorDto dto) throws Exception {
		DoctorModel model = mapper.map(dto, DoctorModel.class);
		return repository.save(model).getId();
	}

	@Transactional
	public void update(long id, UpdateDoctorDto dto) throws DoctorNotFoundException {
		DoctorModel model = this.repository.findById(id).orElseThrow(DoctorNotFoundException::new);
		model.setNome(dto.getNome());
		model.setCep(dto.getCep());
		model.setCelular(dto.getCelular());
		model.setCrm(dto.getCrm());
		model.setTelefone(dto.getTelefone());
		model.setEspecialidade(this.repository.findById(dto.getIdEspecialidade()).get().getEspecialidade());

		repository.save(model);
	}

	@Transactional
	public void remove(long id) throws DoctorNotFoundException {
		objectOrThrow(id);
		repository.deleteById(id);
	}

	@Transactional
	public List<DoctorDto> allObjects() {
		return repository.findAll().stream().map(model -> mapper.map(model, DoctorDto.class))
				.collect(Collectors.toList());
	}

	@Transactional
	public DoctorDto findById(long id) throws DoctorNotFoundException {
		return objectOrThrow(id);
	}

	@Transactional
	DoctorDto objectOrThrow(long id) throws DoctorNotFoundException {
		return repository.findById(id).map(model -> mapper.map(model, DoctorDto.class))
				.orElseThrow(DoctorNotFoundException::new);
	}


}