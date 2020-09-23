package br.com.alura.forum.config.validacao;

import br.com.alura.forum.config.validacao.DTO.ErroFormularioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioDTO> handle(MethodArgumentNotValidException exception){
        List<ErroFormularioDTO> listaDeErroFormulario = new ArrayList<>();
        List<FieldError> erroCampos = exception.getBindingResult().getFieldErrors();
        erroCampos.forEach(erroForm ->{
            String mensagemDeErro = messageSource.getMessage(erroForm, LocaleContextHolder.getLocale());
            ErroFormularioDTO erroDto = new ErroFormularioDTO(erroForm.getField(),mensagemDeErro);
            listaDeErroFormulario.add(erroDto);
        });
        return listaDeErroFormulario;
    }
}
