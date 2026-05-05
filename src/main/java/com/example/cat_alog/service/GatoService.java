package com.example.cat_alog.service;

import com.example.cat_alog.model.Gato;
import com.example.bibliotecaduoc.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatoService {

    @Autowired
    private GatoRepository gatoRepository;

    public List<Gato> getGatos(){
        return gatoRepository.findAll();
    }

    public Gato saveGato(Gato gato){
        return gatoRepository.save(gato);
    }

    public Gato getGatoId(int id){
        return gatoRepository.findById(id).orElse(null);
    }

    public Gato updateGato(Gato gato){
        if (!gatoRepository.existsById(gato.getId())){
            return null;
        }
        return gatoRepository.save(gato);
    }

    public void deleteUsuario(int id){
        gatoRepository.deteleById(id);
    }
}
