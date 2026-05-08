package com.example.cat_alog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cat_alog.model.Gato;
import com.example.cat_alog.repository.GatoRepository;

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
        if (!gatoRepository.existsById(gato.getGatoid())){
            return null;
        }
        return gatoRepository.save(gato);
    }

    public void deleteGato(int id){
        gatoRepository.deleteById(id);
    }
}
