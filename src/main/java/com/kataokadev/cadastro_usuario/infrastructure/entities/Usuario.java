package com.kataokadev.cadastro_usuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.extern.jackson.Jacksonized;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized 
@Table(name = "users")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "nome", length = 50)
    private String nome;

}
