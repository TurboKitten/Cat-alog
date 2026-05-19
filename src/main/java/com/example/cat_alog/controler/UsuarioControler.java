package com.example.cat_alog.controler;

import com.example.cat_alog.dto.UsuarioNacionalidadDTO;
import com.example.cat_alog.model.Usuario;
import com.example.cat_alog.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        System.out.println("[UsuarioController] -> listarUsuarios");
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@Valid @RequestBody Usuario usuario) {
        System.out.println("[UsuarioController] -> agregarUsuario");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }

    @GetMapping("/{usuarioid}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int usuarioid){
        System.out.println("[UsuarioController] -> buscarUsuario id=" + usuarioid);
        Usuario usuario = usuarioService.getUsuarioId(usuarioid);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{usuarioid}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int usuarioid, @Valid @RequestBody Usuario usuario) {
        System.out.println("[UsuarioController] -> actualizarUsuario id=" + usuarioid);
        usuario.setUsuarioid(usuarioid);
        Usuario actualizado = usuarioService.updateUsuario(usuario);
        if (actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{usuarioid}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int usuarioid) {
        System.out.println("[UsuarioController] -> eliminarUsuario id=" + usuarioid);
        usuarioService.deleteUsuario(usuarioid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/con-nacionalidad")
    public ResponseEntity<List<UsuarioNacionalidadDTO>> usuariosPorNacionalidad(){
        System.out.println("[UsuarioControler] -> usuariosPorNacionalidad");
        return ResponseEntity.ok(usuarioService.getUsuariosConNacionalidad());
    }
}
