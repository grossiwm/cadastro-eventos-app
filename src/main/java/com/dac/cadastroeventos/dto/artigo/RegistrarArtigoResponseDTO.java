package com.dac.cadastroeventos.dto.artigo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarArtigoResponseDTO {

    private Long id;

    private Integer ordem;

    private String idioma;

    private String tituloOriginal;

    private String tituloEn;

    private String resumoOriginal;

    private String resumoEn;

    private String palavrasChaveOriginal;

    private String palavrasChaveEn;

    private Integer numeroPaginas;

}
