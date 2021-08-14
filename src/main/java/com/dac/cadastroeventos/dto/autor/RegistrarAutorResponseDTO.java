package com.dac.cadastroeventos.dto.autor;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarAutorResponseDTO {

    private Long id;

    private Integer ordem;

    private String email;

    private String primeiroNome;

    private String meioNome;

    private String sobreNome;

    private String afiliacao;

    private String afiliacaoEn;

    private String pais;

    private String orcid;
}
