package dev.gustavosdaniel.projetospringboot.repository;

import org.springframework.stereotype.Repository;

@Repository // PARA SABER QUE ESSA CLASSE [E UM REPOSITORY
public class MensagemRepository {
    public String obterMensagem() {
        return "Olá do repositorio";
    }
}
