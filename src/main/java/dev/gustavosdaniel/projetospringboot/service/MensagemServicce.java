package dev.gustavosdaniel.projetospringboot.service;

import dev.gustavosdaniel.projetospringboot.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service // PARA FALAR QUE ISSO É UM SERVIÇO (LOGICA DE NEGOCIO)
public class MensagemServicce {

    private final MensagemRepository mensagemRepository;

    public MensagemServicce(MensagemRepository mensagemRepository) { //INJEÇÃO DE DEPENDENCIAS
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.obterMensagem();
    }
}
