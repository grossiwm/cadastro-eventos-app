package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.dto.artigo.RegistrarArtigoRequestDTO;
import com.dac.cadastroeventos.dto.artigo.RegistrarArtigoResponseDTO;
import com.dac.cadastroeventos.dto.volume.RegistrarVolumeRequestDTO;
import com.dac.cadastroeventos.dto.volume.RegistrarVolumeResponseDTO;
import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Volume;
import com.dac.cadastroeventos.repository.ArtigoRepository;
import com.dac.cadastroeventos.utils.ClassesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private ClassesUtils classesUtils;

    public List<Artigo> listaTodosArtigos(){
        return artigoRepository.findAll();
    }

    public Artigo criarArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public RegistrarArtigoResponseDTO criarArtigoDTO(RegistrarArtigoRequestDTO dto) {

        Artigo artigo = classesUtils.fazDePara(dto, new Artigo());

        this.criarArtigo(artigo);

        RegistrarArtigoResponseDTO responseDTO = new RegistrarArtigoResponseDTO();

        classesUtils.fazDePara(artigo, responseDTO);

        return responseDTO;
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
