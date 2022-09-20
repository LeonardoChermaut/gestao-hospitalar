package com.sistemadecadastro.dto.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DoctorBaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size( max = 120, message = "Tamanho do nome inválido")
    private String nome;

    @NotNull
    @Size(max = 7)
    private String crm;

    @NotNull
    @Length(max = 12)
    private String celular;

    @NotNull
    @Length(max = 11)
    private String telefone;

    @NotNull
    @Length(max = 8)
    private String cep;

}