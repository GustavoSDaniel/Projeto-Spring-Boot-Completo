package dev.gustavosdaniel.projetospringboot.controller;

import dev.gustavosdaniel.projetospringboot.model.Usuario;
import dev.gustavosdaniel.projetospringboot.security.JwtUtil;
import dev.gustavosdaniel.projetospringboot.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService; //INJETANDO DEPENDENCIA

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register") // REGISTRANDO USUARIO
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        Usuario usuario = usuarioService.registrarUsuarios(request.get("userName"), "password");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login") // VALIDANDO USUARIO
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<Usuario> usuario = usuarioService.buscarUserName(request.get("userName"));
        if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
            String token = JwtUtil.generateToken(usuario.get().getUserName());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }
}
