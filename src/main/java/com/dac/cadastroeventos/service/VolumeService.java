package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.dto.volume.RegistrarVolumeRequestDTO;
import com.dac.cadastroeventos.dto.volume.RegistrarVolumeResponseDTO;
import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Volume;
import com.dac.cadastroeventos.repository.VolumeRepository;
import com.dac.cadastroeventos.utils.ClassesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private ClassesUtils classesUtils;

    public List<Volume> listaTodosVolumes(){
        return volumeRepository.findAll();
    }

    public List<Artigo> listaArtigosPorVolume(Long id){
        return volumeRepository.buscaArtigosDeVolume(id);
    }

    public Volume criarVolume(Volume volume) {
        return volumeRepository.save(volume);
    }

    public RegistrarVolumeResponseDTO criarVolumeDTO(RegistrarVolumeRequestDTO dto) {

        Volume volume = classesUtils.fazDePara(dto, new Volume());

        this.criarVolume(volume);

        RegistrarVolumeResponseDTO responseDTO = new RegistrarVolumeResponseDTO();

        classesUtils.fazDePara(volume, responseDTO);

        return responseDTO;
    }

    public Optional<Volume> buscarPorId(Long id) {
        return volumeRepository.findById(id);
    }

    public Volume alterarVolume(Volume volume) {
        return volumeRepository.save(volume);
    }

    public void deletaVolume(Volume volume) {
        volumeRepository.delete(volume);
    }
}
