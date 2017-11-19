/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIvros;

import java.io.Serializable;
import javax.annotation.Generated;
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
    
    
    
}
