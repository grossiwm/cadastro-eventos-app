package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.dto.autor.RegistrarAutorRequestDTO;
import com.dac.cadastroeventos.dto.autor.RegistrarAutorResponseDTO;
import com.dac.cadastroeventos.exception.ArtigoNaoEncontradoException;
import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Autor;
import com.dac.cadastroeventos.repository.ArtigoRepository;
import com.dac.cadastroeventos.repository.AutorRepository;
import com.dac.cadastroeventos.utils.ClassesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ClassesUtils classesUtils;

    @Autowired
    private ArtigoRepository artigoRepository;

    public List<Autor> listaTodosAutores(){
        return autorRepository.findAll();
    }

    public Autor criarAutor(Autor Autor) {
        return autorRepository.save(Autor);
    }

    public RegistrarAutorResponseDTO criarAutorDTO(RegistrarAutorRequestDTO dto) throws ArtigoNaoEncontradoException {

        Optional<Artigo> artigoOp = artigoRepository.findById(dto.getArtigoId());

        if (artigoOp.isEmpty())
            throw new ArtigoNaoEncontradoException();

        Autor autor = classesUtils.fazDePara(dto, new Autor());

        autor.setArtigo(artigoOp.get());

        this.criarAutor(autor);

        RegistrarAutorResponseDTO responseDTO = new RegistrarAutorResponseDTO();

        classesUtils.fazDePara(autor, responseDTO);

        return responseDTO;
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor alterarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletaAutor(Autor autor) {
        autorRepository.delete(autor);
    }
}
