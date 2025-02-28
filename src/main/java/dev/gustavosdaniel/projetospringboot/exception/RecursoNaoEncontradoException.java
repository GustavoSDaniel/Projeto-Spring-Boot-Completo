package dev.gustavosdaniel.projetospringboot.exception;

public class RecursoNaoEncontradoException extends RuntimeException{ // QUANDO DIGITAR UM PRODUTO QUE NÃO FOI ENTRADO VAI RETORNAR ESSA EXECAO
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
