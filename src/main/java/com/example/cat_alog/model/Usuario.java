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

    @NotBlank
    String nombreUsuario;

    @NotBlank
    String correoUsuario;

    @NotBlank
    String contraseñaUsuario;

    @NotBlank
    String nacionalidadUsuario;

    @OneToOne()
    private Gato gatos; 
}
