package com.dac.cadastroeventos.controller;

import com.dac.cadastroeventos.model.Artigo;
import com.dac.cadastroeventos.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Objects;
import java.util.Optional;

@Controller
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @PostMapping("/registrar")
    public ResponseEntity<Artigo> registrarArtigo(Artigo artigo) {

        Artigo novoArtigo = artigoService.criarArtigo(artigo);

        return ResponseEntity.status(201).body(novoArtigo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> buscarArtigo(@PathVariable Long id) {
        Optional<Artigo> artigoOp = artigoService.buscarPorId(id);

        if (artigoOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.status(200).body(artigoOp.get());
    }

    @PutMapping("/alterar")
    public ResponseEntity<Artigo> alterarArtigo(Artigo artigo) {

        Long id = artigo.getId();

        if (Objects.isNull(id))
            return ResponseEntity.badRequest().body(null);

        Optional<Artigo> artigoOp = artigoService.buscarPorId(id);

        if (artigoOp.isEmpty())
            return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(artigoService.alterarArtigo(artigo));


    }
}
