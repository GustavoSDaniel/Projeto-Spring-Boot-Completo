package dev.gustavosdaniel.projetospringboot.service;

import dev.gustavosdaniel.projetospringboot.model.Usuario;
import dev.gustavosdaniel.projetospringboot.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

   private final UsuarioRepository usuarioRepository; // INJETANDO DEPENDENCIAS
   private final PasswordEncoder passwordEncoder; // INJETANDO DEPENDENCIAS

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder(); // CRIPTOGRAFA SENHAS ANTES DE SALVAR NO BANCO DE DADOS
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuarios(String userName, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(userName, senhaCriptografada); // VAI POASAR O USUARIO E A SENHA CRIPTOGAFADA
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarUserName(String userName) {

        return usuarioRepository.findByUserName(userName);
    }
}
