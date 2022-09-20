package com.sistemadecadastro.dto.SpecsDoctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SpecsBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    private long especialidade;

    @NotNull
    private long medico;

}