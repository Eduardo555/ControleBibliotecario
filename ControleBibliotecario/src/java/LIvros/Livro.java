/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIvros;

import Emprestimos.Emprestimo;
import Usuarios.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import Conversores.BaseEntity;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "LIVROS")
public class Livro implements BaseEntity,Serializable{
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
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy ="livro",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
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
    
    
    @Override
    public Long getId() {
        return new Long(cod_livro);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cod_livro);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.assunto);
        hash = 97 * hash + Objects.hashCode(this.dataCadastro);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + Objects.hashCode(this.autor);
        hash = 97 * hash + Objects.hashCode(this.editora);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.emprestimos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.cod_livro, other.cod_livro)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.emprestimos, other.emprestimos)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
