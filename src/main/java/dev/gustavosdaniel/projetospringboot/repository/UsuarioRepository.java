package dev.gustavosdaniel.projetospringboot.repository;

import dev.gustavosdaniel.projetospringboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUserName(String userName);
}
