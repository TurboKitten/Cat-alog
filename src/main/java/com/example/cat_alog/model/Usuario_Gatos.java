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
@Table(name = "usuario_gatos")
public class Usuario_Gatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioid;

    @Column(unique = true, nullable = false)
    private String nombreUsuario;

    @NotBlank
    private String correoUsuario;

    @Column(nullable = false)
    private String contraseñaUsuario;

    @NotBlank
    private String nacionalidadUsuario;

    @Column(nullable = false)
    private String role;

}
