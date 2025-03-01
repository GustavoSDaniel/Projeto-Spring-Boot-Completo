package dev.gustavosdaniel.projetospringboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // FALA QUE O CAMPO NÃO PODE SER NULO TEM QUE SER PREENCHIDO
    private String userName;

    @Column(nullable = false) // FALA QUE O CAMPO NÃO PODE SER NULO TEM QUE SER PREENCHIDO
    private String password;

    public Usuario() {
    }

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }
}
