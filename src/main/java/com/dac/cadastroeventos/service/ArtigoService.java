package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public List<Artigo> listaTodosArtigos(){
        return artigoRepository.findAll();
    }

    public Artigo criarArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public Optional<Artigo> buscarPorId(Long id) {
        return artigoRepository.findById(id);
    }

    public Artigo alterarArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public void deletaArtigo(Artigo artigo) {
        artigoRepository.delete(artigo);
    }
}
