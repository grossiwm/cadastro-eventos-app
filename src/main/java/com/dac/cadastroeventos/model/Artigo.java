package com.dac.cadastroeventos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "artigo")
public class Artigo {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Integer ordem;

    @Column(length = 2)
    @Getter
    @Setter
    private String idioma;

    @Getter
    @Setter
    @Column(length = 256, name = "titulo_original")
    private String tituloOriginal;

    @Getter
    @Setter
    @Column(length = 256, name = "titulo_en")
    private String tituloEn;

    @Getter
    @Setter
    @Column(length = 2048, name = "resumo_original")
    private String resumoOriginal;

    @Getter
    @Setter
    @Column(length = 2048, name = "resumo_en")
    private String resumoEn;

    @Getter
    @Setter
    @Column(name = "palavras_chave_original", length = 256)
    private String palavrasChaveOriginal;

    @Getter
    @Setter
    @Column(name = "palavras_chave_en", length = 256)
    private String palavrasChaveEn;

    @Getter
    @Setter
    @Column(name = "numero_paginas")
    private Integer numeroPaginas;

    @Getter
    @Setter
    @ManyToOne
    @JsonIgnore
    private Volume volume;

    @OneToMany
    @JoinColumn(name = "artigo_id")
    @Setter
    @JsonIgnore
    private List<Autor> autores;


    public List<Autor> getAutores() {
        return autores.stream().sorted(Comparator.comparing(Autor::getOrdem)).collect(Collectors.toList());
    }
}
