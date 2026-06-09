package com.example.cat_alog.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String nombreUsuario;
    private String contraseñaUsuario;
}
