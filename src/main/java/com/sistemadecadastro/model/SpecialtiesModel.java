
package com.sistemadecadastro.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Especialidades")
public class SpecialtiesModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @Size(max = 50)
    private String nome;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidade")
    private Set<SpecsDoctorModel> specs;

}

