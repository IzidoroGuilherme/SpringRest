package br.com.alura.forum.config.validacao.DTO;

import lombok.Getter;

@Getter
public class ErroFormularioDTO {

    private String campo;
    private String erro;

    public ErroFormularioDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
