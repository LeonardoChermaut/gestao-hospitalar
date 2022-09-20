package com.sistemadecadastro.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medico")

public class DoctorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    @Length(max = 120)
    private String nome;

    @Column(nullable = false, unique = true)
    @Size(max = 7)
    private String crm;

    @Column(nullable = false, unique = true)
    @Length(max = 12)
    private String celular;

    @Column(nullable = false, unique = true)
    @Length(max = 11)
    private String telefone;

    @Column(nullable = false, unique = true)
    @Length(max = 8)
    private String cep;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    private Set<SpecsDoctorModel> specs;
}

