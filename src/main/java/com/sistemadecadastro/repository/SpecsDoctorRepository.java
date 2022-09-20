package com.sistemadecadastro.repository;

import com.sistemadecadastro.model.SpecsDoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecsDoctorRepository extends JpaRepository<SpecsDoctorModel, Long> {
}
