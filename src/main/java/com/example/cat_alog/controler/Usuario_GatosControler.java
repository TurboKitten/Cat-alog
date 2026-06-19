package com.example.cat_alog.controler;

import com.example.cat_alog.dto.UsuarioNacionalidadDTO;
import com.example.cat_alog.model.Usuario_Gatos;
import com.example.cat_alog.service.Usuario_GatosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class Usuario_GatosControler {

    @Autowired
    private Usuario_GatosService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario_Gatos>> listarUsuarios(){
        System.out.println("[UsuarioController] -> listarUsuarios");
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario_Gatos> agregarUsuario(@Valid @RequestBody Usuario_Gatos usuario) {
        System.out.println("[UsuarioController] -> agregarUsuario");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }

    @GetMapping("/id/{usuarioid}")
    public ResponseEntity<Usuario_Gatos> buscarUsuario(@PathVariable int usuarioid){
        System.out.println("[UsuarioController] -> buscarUsuario id=" + usuarioid);
        Usuario_Gatos usuario = usuarioService.getUsuarioId(usuarioid);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/id/{usuarioid}")
    public ResponseEntity<Usuario_Gatos> actualizarUsuario(@PathVariable int usuarioid, @Valid @RequestBody Usuario_Gatos usuario) {
        System.out.println("[UsuarioController] -> actualizarUsuario id=" + usuarioid);
        usuario.setUsuarioid(usuarioid);
        Usuario_Gatos actualizado = usuarioService.updateUsuario(usuario);
        if (actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/id/{usuarioid}")
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
