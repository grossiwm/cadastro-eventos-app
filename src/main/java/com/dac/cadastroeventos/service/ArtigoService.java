package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.dto.artigo.RegistrarArtigoRequestDTO;
import com.dac.cadastroeventos.dto.artigo.RegistrarArtigoResponseDTO;
import com.dac.cadastroeventos.exception.VolumeNaoEncontradoException;
import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Volume;
import com.dac.cadastroeventos.repository.ArtigoRepository;
import com.dac.cadastroeventos.repository.VolumeRepository;
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
    private VolumeRepository volumeRepository;

    @Autowired
    private ClassesUtils classesUtils;

    public List<Artigo> listaTodosArtigos(){
        return artigoRepository.findAll();
    }

    public Artigo criarArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public RegistrarArtigoResponseDTO criarArtigoDTO(RegistrarArtigoRequestDTO dto) throws VolumeNaoEncontradoException {

        Optional<Volume> volumeOp = volumeRepository.findById(dto.getVolumeId());

        if (volumeOp.isEmpty())
            throw new VolumeNaoEncontradoException();

        Artigo artigo = classesUtils.fazDePara(dto, new Artigo());

        artigo.setVolume(volumeOp.get());
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
