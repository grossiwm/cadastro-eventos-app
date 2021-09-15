package com.dac.cadastroeventos.controller;

import com.dac.cadastroeventos.dto.artigo.RegistrarArtigoRequestDTO;
import com.dac.cadastroeventos.dto.artigo.RegistrarArtigoResponseDTO;
import com.dac.cadastroeventos.exception.VolumeNaoEncontradoException;
import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.model.Autor;
import com.dac.cadastroeventos.service.ArtigoService;
import com.dac.cadastroeventos.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/artigo")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @PostMapping("/registrar")
    public ResponseEntity<RegistrarArtigoResponseDTO> registrarArtigo(@RequestBody RegistrarArtigoRequestDTO dto) throws VolumeNaoEncontradoException {

        RegistrarArtigoResponseDTO novoArtigo = artigoService.criarArtigoDTO(dto);

        return ResponseEntity.status(201).body(novoArtigo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Artigo>> listarArtigos() {
        return ResponseEntity.status(200).body(artigoService.listaTodosArtigos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Artigo> buscarArtigo(@PathVariable Long id) {
        Optional<Artigo> artigoOp = artigoService.buscarPorId(id);

        if (artigoOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.status(200).body(artigoOp.get());
    }

    @GetMapping("/{id}/autores")
    public ResponseEntity<List<Autor>> buscarAutores(@PathVariable Long id) {
        Optional<Artigo> artigoOp = artigoService.buscarPorId(id);

        if (artigoOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        List<Autor> autores = artigoService.buscaAutoresDeArtigo(artigoOp.get());

        return ResponseEntity.status(200).body(autores);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Artigo> alterarArtigo(@RequestBody Artigo artigo) {

        Long id = artigo.getId();

        if (Objects.isNull(id))
            return ResponseEntity.badRequest().body(null);

        Optional<Artigo> artigoOp = artigoService.buscarPorId(id);

        if (artigoOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(artigoService.alterarArtigo(artigo));

    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Object> removeArtigo(@PathVariable Long id) {

        Optional<Artigo> artigoOp = artigoService.buscarPorId(id);

        if (artigoOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        artigoService.deletaArtigo(artigoOp.get());

        return ResponseEntity.status(204).body(null);
    }
}
