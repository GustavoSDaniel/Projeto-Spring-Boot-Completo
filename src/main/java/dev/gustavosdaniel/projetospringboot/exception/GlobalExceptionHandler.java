package dev.gustavosdaniel.projetospringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice // ESSA ANOTAÇÃO SERVE PARA TRATAR EXCEÇÕES GLOBAIS
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class) // É USADA NA CLASSE QUE CONTEM O @RestControllerAdvice PARA TRATAR EXCEÇÕES PERSONALIZADAS
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
        Map<String, Object> body = new LinkedHashMap<>(); // CRIA UMA LISTA DE VALORES DO TIPO STRING
        body.put("timestamp", LocalDateTime.now()); // A HORA QUE OCORREU A AXCEÇÃO
        body.put("status", HttpStatus.NOT_FOUND.value()); // STATUS DO ERRO
        body.put("error", "Recurso não encontrado");
        body.put("message", ex.getMessage()); // MENSAGEM DA EXCEÇÃO
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // EXEÇÃO MAIS GENERICA AINDA
    @ExceptionHandler(Exception.class) // É USADA NA CLASSE QUE CONTEM O @RestControllerAdvice PARA TRATAR EXCEÇÕES PERSONALIZADAS
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        Map<String, Object> body = new LinkedHashMap<>(); // CRIA UMA LISTA DE VALORES DO TIPO STRING de exceções
        body.put("timestamp", LocalDateTime.now()); // A HORA QUE OCORREU A AXCEÇÃO
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // STATUS DO ERRO
        body.put("error", "Erro interno do servidor");
        body.put("message", ex.getMessage()); // MENSAGEM DA EXCEÇÃO
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
