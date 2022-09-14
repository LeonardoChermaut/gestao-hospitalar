package com.sistemadecadastro.repository;


import com.sistemadecadastro.model.SpecialtiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialtiesRepository extends JpaRepository<SpecialtiesModel, Long> {

    Optional<SpecialtiesModel> findByNome(String nome);


}
