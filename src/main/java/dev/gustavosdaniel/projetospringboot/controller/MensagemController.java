package dev.gustavosdaniel.projetospringboot.controller;

import dev.gustavosdaniel.projetospringboot.service.MensagemServicce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // ONDE FICA OS ENDIPOINTS
public class MensagemController {
    private final MensagemServicce mensagemService;

    public MensagemController(MensagemServicce mensagemService) {
        this.mensagemService = mensagemService;
    }
    @GetMapping("/mensagem") //PARA PODE ACESSAR VIA URL
    public String mensagem() {
        return mensagemService.obterMensagem();
    }
}
