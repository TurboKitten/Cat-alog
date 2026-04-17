package com.example.cat_alog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @NotNull
    int usuarioid;

    @NotBlank
    String nombreUsuario;

    @NotBlank
    String correoUsuario;

    @NotBlank
    String contraseñaUsuario;
}
