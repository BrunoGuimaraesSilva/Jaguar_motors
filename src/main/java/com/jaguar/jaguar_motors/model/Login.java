package com.jaguar.jaguar_motors.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Erro ao salvar o login")
    @Column(nullable = false, unique = true)
    private String login;

    @NotNull(message = "Erro ao salvar a senha")
    @Column(nullable = false)
    private String senha;

    @NotNull(message = "Erro ao salvar o id_usuario")
    @Column(nullable = false)
    private Integer id_usuario;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

}
