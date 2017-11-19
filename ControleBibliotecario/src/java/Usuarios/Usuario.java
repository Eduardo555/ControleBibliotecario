/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "cod_usuario")
    Integer cod_usuario;
    String nome;
    String email;
    String senha;

    public Integer getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(Integer cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
