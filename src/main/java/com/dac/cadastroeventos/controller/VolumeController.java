package com.dac.cadastroeventos.controller;

import com.dac.cadastroeventos.dto.volume.RegistrarVolumeRequestDTO;
import com.dac.cadastroeventos.dto.volume.RegistrarVolumeResponseDTO;
import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Volume;
import com.dac.cadastroeventos.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/volume")
public class VolumeController {

    @Autowired
    private VolumeService volumeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Volume>> listarVolumes() {
        return ResponseEntity.status(200).body(volumeService.listaTodosVolumes());
    }

    @PostMapping("/registrar")
    public ResponseEntity<RegistrarVolumeResponseDTO> registrarVolume(@RequestBody RegistrarVolumeRequestDTO dto) {

        RegistrarVolumeResponseDTO novoVolume = volumeService.criarVolumeDTO(dto);

        return ResponseEntity.status(201).body(novoVolume);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Volume> buscarVolume(@PathVariable Long id) {
        Optional<Volume> volumeOp = volumeService.buscarPorId(id);

        if (volumeOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.status(200).body(volumeOp.get());
    }

    @GetMapping("/{id}/artigos/listar")
    public ResponseEntity<List<Artigo>> listarArtigosPorVolume(@PathVariable Long id) {
        return ResponseEntity.status(200).body(volumeService.listaArtigosPorVolume(id));
    }

    @GetMapping("/{id}/autores/listar")
    public ResponseEntity<List<Map<Object, Object>>> listarAutoresPorVolume(@PathVariable Long id) {
        return ResponseEntity.status(200).body(volumeService.listaAutoresPorVolume(id));
    }

    @PutMapping("/alterar")
    public ResponseEntity<Volume> alterarVolume(@RequestBody Volume volume) {

        Long id = volume.getId();

        if (Objects.isNull(id))
            return ResponseEntity.badRequest().body(null);

        Optional<Volume> volumeOp = volumeService.buscarPorId(id);

        if (volumeOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(volumeService.alterarVolume(volume));

    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Object> removeVolume(@PathVariable Long id) {

        Optional<Volume> volumeOp = volumeService.buscarPorId(id);

        if (volumeOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        volumeService.deletaVolume(volumeOp.get());

        return ResponseEntity.status(204).body(null);
    }
}
