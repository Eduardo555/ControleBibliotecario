/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprestimos;

import Clientes.Cliente;
import LIvros.Livro;
import LIvros.Livro_;
import Usuarios.Usuario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Conversores.BaseEntity;
import java.util.Objects;

/**
 *
 * @author eduardo
 */
@Entity
@Table(name = "EMPRESTIMOS")
public class Emprestimo implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "cod_emprestimo")
    Integer cod_emprestimo;
    String data_prevista_devolucao;
    String data_devolucao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_livro")
    private Livro livro;

    public Integer getCod_emprestimo() {
        return cod_emprestimo;
    }

    public void setCod_emprestimo(Integer cod_emprestimo) {
        this.cod_emprestimo = cod_emprestimo;
    }

    public String getData_prevista_devolucao() {
        return data_prevista_devolucao;
    }

    public void setData_prevista_devolucao(String data_prevista_devolucao) {
        this.data_prevista_devolucao = data_prevista_devolucao;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cod_emprestimo);
        hash = 89 * hash + Objects.hashCode(this.data_prevista_devolucao);
        hash = 89 * hash + Objects.hashCode(this.data_devolucao);
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.cliente);
        hash = 89 * hash + Objects.hashCode(this.livro);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.data_prevista_devolucao, other.data_prevista_devolucao)) {
            return false;
        }
        if (!Objects.equals(this.data_devolucao, other.data_devolucao)) {
            return false;
        }
        if (!Objects.equals(this.cod_emprestimo, other.cod_emprestimo)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        return true;
    }
   
    
    
}
