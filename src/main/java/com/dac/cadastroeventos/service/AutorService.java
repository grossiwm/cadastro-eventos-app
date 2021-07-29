package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.model.Autor;
import com.dac.cadastroeventos.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listaTodosAutores(){
        return autorRepository.findAll();
    }

    public Autor criarAutor(Autor Autor) {
        return autorRepository.save(Autor);
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor alterarAutor(Autor Autor) {
        return autorRepository.save(Autor);
    }

    public void deletaAutor(Autor autor) {
        autorRepository.delete(autor);
    }
}
