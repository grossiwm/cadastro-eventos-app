package com.dac.cadastroeventos.dto.volume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarVolumeResponseDTO {

    private Long id;

    private String sigla;

    private Integer edicao;

    private String cidade;

    private String dataInicio;

    private String descricaoEn;

    private String descricaoPt;
}
