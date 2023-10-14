package br.com.rocketseat.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice é para definir classes globais no tratamento de exceções.
 * Toda exceção que tiver vai passar por esse controler e se a exceção for do tipo
 * tratado abaixo ele vai cair no seu tratamento abaixo.
 */

@ControllerAdvice
public class ExceptionHandlerController {

    /** Tratando erros do tipo HttpMessageNotReadableException */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMostSpecificCause().getMessage());
    }
}
