package com.dac.cadastroeventos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="volume")
public class Volume {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(length = 32)
    @Getter
    @Setter
    private String sigla;

    @Getter
    @Setter
    private Integer edicao;

    @Column(length = 64)
    @Getter
    @Setter
    private String cidade;

    @Column(name = "data_inicio")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Getter
    @Setter
    private String dataInicio;

    @Column(name = "descricao_en", length = 2048)
    @Getter
    @Setter
    private String descricaoEn;

    @Column(name = "descricao_pt", length = 2048)
    @Getter
    @Setter
    private String descricaoPt;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="volume_id")
    @Setter
    private List<Artigo> artigos;

    public List<Artigo> getArtigos() {
        return artigos.stream().sorted(Comparator.comparing(Artigo::getOrdem)).collect(Collectors.toList());
    }
}
