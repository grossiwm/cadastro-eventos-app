package com.dac.cadastroeventos.controller;

import com.dac.cadastroeventos.dto.autor.RegistrarAutorRequestDTO;
import com.dac.cadastroeventos.dto.autor.RegistrarAutorResponseDTO;
import com.dac.cadastroeventos.exception.ArtigoNaoEncontradoException;
import com.dac.cadastroeventos.model.Autor;
import com.dac.cadastroeventos.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Autor>> listarAutor() {
        return ResponseEntity.status(200).body(autorService.listaTodosAutores());
    }

    @PostMapping("/registrar")
    public ResponseEntity<RegistrarAutorResponseDTO> registrarAutor(@RequestBody RegistrarAutorRequestDTO dto) throws ArtigoNaoEncontradoException {

        RegistrarAutorResponseDTO novoAutor = autorService.criarAutorDTO(dto);

        return ResponseEntity.status(201).body(novoAutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Long id) {
        Optional<Autor> autorOp = autorService.buscarPorId(id);

        if (autorOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.status(200).body(autorOp.get());
    }

    @PutMapping("/alterar")
    public ResponseEntity<Autor> alterarAutor(@RequestBody Autor autor) {

        Long id = autor.getId();

        if (Objects.isNull(id))
            return ResponseEntity.badRequest().body(null);

        Optional<Autor> autorOp = autorService.buscarPorId(id);

        if (autorOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(autorService.alterarAutor(autor));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Object> removeAutor(@PathVariable Long id) {

        Optional<Autor> autorOp = autorService.buscarPorId(id);

        if (autorOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        autorService.deletaAutor(autorOp.get());

        return ResponseEntity.status(204).body(null);
    }
}
