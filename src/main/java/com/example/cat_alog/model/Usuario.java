package com.example.cat_alog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int usuarioid;

    @Column(unique = true, nullable = false)
    String nombreUsuario;

    @NotBlank
    String correoUsuario;

    @Column(nullable = false)
    String contraseñaUsuario;

    @NotBlank
    String nacionalidadUsuario;

    @Column(nullable = false)
    private String role;

    @OneToOne()
    private Gato gatos; 
}
