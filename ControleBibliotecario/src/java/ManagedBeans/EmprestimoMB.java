/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Clientes.Cliente;
import Emprestimos.Emprestimo;
import LIvros.Livro;
import Usuarios.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped
public class EmprestimoMB {

    Emprestimo emprestimo = new Emprestimo();
    Usuario usuario = new Usuario();    
    Livro livro = new Livro();
    Cliente cliente = new Cliente();
    /**
     * Creates a new instance of EmprestimoMB
     */
    public EmprestimoMB() {
    }
    
    public void novoEmprestimo(){
        
    }
    
    public void salvarEmprestimo(){
        
        //Recupera usuario da sessao
        FacesContext fc = FacesContext.getCurrentInstance();
        usuario.setCod_usuario((Integer) fc.getExternalContext().getSessionMap().get("usuario")); 
        
        usuario.getEmprestimos().add(emprestimo);
        emprestimo.setUsuario(this.usuario);
        
        cliente.getEmprestimos().add(emprestimo);
        emprestimo.setCliente(this.cliente);
        
        livro.getEmprestimos().add(emprestimo);
        emprestimo.setLivro(this.livro);
        
        emprestimo.setData_devolucao("00/00/0000");
        emprestimo.setData_prevista_devolucao("20/12/2017");
        
        Emprestimos.EmpresitmoControlador.salvar(emprestimo);
        
    }
    
}
