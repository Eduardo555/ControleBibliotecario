/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIvros;

import Usuarios.Usuario;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "LIVROS")
public class Livro implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "cod_livro")
    Integer cod_livro;
    String nome;
    String assunto;
    String dataCadastro;
    String observacao;
    
    String autor;
    String editora;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    public Integer getCod_livro() {
        return cod_livro;
    }

    public void setCod_livro(Integer cod_livro) {
        this.cod_livro = cod_livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
