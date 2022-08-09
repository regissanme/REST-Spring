package br.com.regissanme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Projeto: REST-Spring
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 08/08/2022
 * Hora: 12:06
 */
@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturaErroNull(){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "O nome ou preço do produto não pode ser vazio");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturarErroPreco (){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "O preço não pode ser negativo");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
