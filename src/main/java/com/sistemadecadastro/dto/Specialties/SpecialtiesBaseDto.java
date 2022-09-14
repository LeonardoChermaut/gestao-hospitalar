package com.sistemadecadastro.dto.Specialties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SpecialtiesBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 50)
    private String nome;

}