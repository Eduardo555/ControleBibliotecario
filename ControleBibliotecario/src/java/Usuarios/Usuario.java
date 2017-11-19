/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Clientes.Cliente;
import LIvros.Livro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy ="usuario",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Livro> livros = new ArrayList<Livro>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="usuario",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
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
    
    public void addLivro(Livro livro) {
        getLivros().add(livro);
        livro.setUsuario(this);
    }
    
}
