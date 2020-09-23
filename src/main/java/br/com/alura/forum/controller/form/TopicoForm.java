package br.com.alura.forum.controller.form;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicoForm {
    @NotNull @NotBlank
    private String titulo;

    @NotNull @NotBlank
    private String mensagem;

    @NotNull @NotBlank
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository) {
        return new Topico(this.titulo,this.mensagem, cursoRepository.findByNome(nomeCurso));
    }
}
