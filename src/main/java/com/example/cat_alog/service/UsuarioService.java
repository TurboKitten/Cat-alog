package com.example.cat_alog.service;

import com.example.cat_alog.model.Usuario;
import com.example.bibliotecaduoc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioId(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario usuario){
        if (!usuarioRepository.existsById(usuario.getId())){
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id){
        usuarioRepository.deteleById(id);
    }
}
