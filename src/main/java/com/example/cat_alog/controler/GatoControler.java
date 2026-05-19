package com.example.cat_alog.controler;

import com.example.cat_alog.model.Gato;
import com.example.cat_alog.service.GatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gatos")
public class GatoControler {

    @Autowired
    private GatoService gatoService;

    @GetMapping
    public ResponseEntity<List<Gato>> listarGatos(){
        System.out.println("[GatoController] -> listarGatos");
        return ResponseEntity.ok(gatoService.getGatos());
    }

    @PostMapping
    public ResponseEntity<Gato> agregarGato(@Valid @RequestBody Gato gato) {
        System.out.println("[GatoController] -> agregarGato");
        return ResponseEntity.status(HttpStatus.CREATED).body(gatoService.saveGato(gato));
    }

    @GetMapping("/{gatoid}")
    public ResponseEntity<Gato> buscarGato(@PathVariable int gatoid){
        System.out.println("[GatoController] -> buscarGato id=" + gatoid);
        Gato gato = gatoService.getGatoId(gatoid);
        if (gato == null) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(gato);
    }

    @PutMapping("/{gatoid}")
    public ResponseEntity<Gato> actualizarGato(@PathVariable int gatoid, @Valid @RequestBody Gato gato) {
        System.out.println("[GatoController] -> actualizarGato id=" + gatoid);
        gato.setGatoid(gatoid);
        Gato actualizado = gatoService.updateGato(gato);
        if (actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{gatoid}")
    public ResponseEntity<Void> eliminarGato(@PathVariable int gatoid) {
        System.out.println("[GatoController] -> eliminarGato id=" + gatoid);
        gatoService.deleteGato(gatoid);
        return ResponseEntity.noContent().build();
    }
}
