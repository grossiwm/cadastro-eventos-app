package com.dac.cadastroeventos.controller;

import com.dac.cadastroeventos.model.Volume;
import com.dac.cadastroeventos.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/volume")
public class VolumeController {

    @Autowired
    private VolumeService volumeService;

    @PostMapping("/registrar")
    public ResponseEntity<Volume> registrarVolume(Volume volume) {

        Volume novoVolume = volumeService.criarVolume(volume);

        return ResponseEntity.status(201).body(novoVolume);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Volume> buscarVolume(@PathVariable Long id) {
        Optional<Volume> volumeOp = volumeService.buscarPorId(id);

        if (volumeOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.status(200).body(volumeOp.get());
    }

    @PutMapping("/alterar")
    public ResponseEntity<Volume> alterarVolume(Volume volume) {

        Long id = volume.getId();

        if (Objects.isNull(id))
            return ResponseEntity.badRequest().body(null);

        Optional<Volume> volumeOp = volumeService.buscarPorId(id);

        if (volumeOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(volumeService.alterarVolume(volume));


    }
}
