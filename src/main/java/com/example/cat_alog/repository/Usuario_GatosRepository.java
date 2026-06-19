package com.example.cat_alog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cat_alog.model.Usuario_Gatos;
import java.util.Optional;

@Repository
public interface Usuario_GatosRepository extends JpaRepository<Usuario_Gatos, Integer>{
    Optional<Usuario_Gatos> findByNombreUsuario(String nombreUsuario);
}