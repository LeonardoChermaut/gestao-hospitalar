package com.sistemadecadastro.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "especialidade_medico")
public class SpecsDoctorModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_especialidade")
    private SpecialtiesModel especialidade;

    @ManyToOne
    @JoinColumn(name = "id_médico")
    private DoctorModel medico;

}
