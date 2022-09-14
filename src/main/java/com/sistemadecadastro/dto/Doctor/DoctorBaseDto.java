package com.sistemadecadastro.dto.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DoctorBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 3, max = 120, message = "Tamanho Inválido")
    private String nome;

    @NotNull
    @Size(max = 7)
    private int crm;

    @NotNull
    @Size(max = 12)
    private int celular;

    @NotNull
    @Size(max = 11)
    private int telefone;

    @NotNull
    private int cep;

    @NotNull
    private long idEspecialidade;

}