package com.sistemadecadastro.repository;

import com.sistemadecadastro.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {

    Optional<DoctorModel> findByEmail(String email);

    Optional<DoctorModel> findByNome(String nome);


}
