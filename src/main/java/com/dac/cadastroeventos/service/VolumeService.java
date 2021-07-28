package com.dac.cadastroeventos.service;

import com.dac.cadastroeventos.model.Volume;
import com.dac.cadastroeventos.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VolumeService {

    @Autowired
    private VolumeRepository volumeRepository;

    public Volume criarVolume(Volume volume) {
        return volumeRepository.save(volume);
    }

    public Optional<Volume> buscarPorId(Long id) {
        return volumeRepository.findById(id);
    }

    public Volume alterarVolume(Volume volume) {
        return volumeRepository.save(volume);
    }
}
