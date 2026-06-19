package com.example.cat_alog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat_alog.dto.UsuarioNacionalidadDTO;
import com.example.cat_alog.model.Usuario_Gatos;
import com.example.cat_alog.repository.Usuario_GatosRepository;

@Service
public class Usuario_GatosService {

    @Autowired
    private Usuario_GatosRepository usuarioRepository;

    public List<Usuario_Gatos> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario_Gatos saveUsuario(Usuario_Gatos usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario_Gatos getUsuarioId(int id){
        return usuarioRepository.findById(id).orElse(null);
    }   

    public Usuario_Gatos updateUsuario(Usuario_Gatos usuario){
        if (!usuarioRepository.existsById(usuario.getUsuarioid())){
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id){
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioNacionalidadDTO> getUsuariosConNacionalidad() {
        return usuarioRepository.findAll().stream()
            .map(u -> new UsuarioNacionalidadDTO(
                u.getNombreUsuario(),
                u.getNacionalidadUsuario()
            ))
            .toList();
    }
}
