package com.dac.cadastroeventos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity(name = "autor")
public class Autor {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Integer ordem;

    @Email
    @Getter
    @Setter
    private String email;

    @Column(length = 64, name = "primeiro_nome")
    @Getter
    @Setter
    private String primeiroNome;

    @Column(length = 64, name = "meio_nome")
    @Getter
    @Setter
    private String meioNome;

    @Column(length = 64, name = "sobre_nome")
    @Getter
    @Setter
    private String sobreNome;

    @Column(length = 256)
    @Getter
    @Setter
    private String afiliacao;

    @Column(length = 256, name = "afiliacao_en")
    @Getter
    @Setter
    private String afiliacaoEn;

    @Column(length = 2)
    @Getter
    @Setter
    private String pais;

    @Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}-\\d{4}")
    @Getter
    @Setter
    private String OrcID;

    @ManyToOne
    @Getter
    @Setter
    private Artigo artigo;


}
