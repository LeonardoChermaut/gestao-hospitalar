package com.sistemadecadastro.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medico")
public class DoctorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(max = 120)
    private String nome;

    @Column(nullable = false, unique = true)
    @Size(max = 7)
    private int crm;

    @Column(nullable = false, unique = true)
    @Size(max = 12)
    private int celular;

    @Column(nullable = false, unique = true)
    @Size(max = 11)
    private int telefone;

    @Column(nullable = false, unique = true)
    private int cep;

    @ManyToOne
    @JoinColumn(name = "especialidades")
    private SpecialtiesModel especialidade;

}

