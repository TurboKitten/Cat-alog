package com.example.cat_alog;

import com.example.cat_alog.model.Gato;
import com.example.cat_alog.model.Usuario_Gatos;
import com.example.cat_alog.service.GatoService;
import com.example.cat_alog.controler.GatoControler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GatoControlerTest {

    @Mock
    private GatoService gatoService;

    @InjectMocks
    private GatoControler gatoControler;

    @Test
    void crearGato_retorna201_cuandoExisteUsuario() {

        Usuario_Gatos usuario = new Usuario_Gatos();
        Gato gato = new Gato(1, 3, 1, "Donut", "Persa", "Marrona", "Frondosa", "Soberbia", usuario);

        // ""Simulamos""" el comportamiento del servicio (mock):
        when(gatoService.saveGato(gato)).thenReturn(gato);

        // El resultado es un ResponseEntity<Gato> con estado HTTP y cuerpo.
        var respuesta = gatoControler.agregarGato(gato);

        // Para que el test sea completo, verificamos varios aspectos de la respuesta:

        // 1) La respuesta no debe ser nula.
        assertNotNull(respuesta);

        // 2) El estado HTTP esperado al crear un recurso es 201 (CREATED).
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        // 3) El cuerpo de la respuesta debe existir.
        var body = respuesta.getBody();
        assertNotNull(body);

        // 4) Validamos un dato clave del cuerpo para confirmar que se devolvió el gato
        assertEquals("Donut", body.getNombre());

    }
}