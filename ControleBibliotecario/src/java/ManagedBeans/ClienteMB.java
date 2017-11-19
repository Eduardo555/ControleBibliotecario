/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Clientes.Cliente;
import Usuarios.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped
public class ClienteMB {

    /**
     * Creates a new instance of ClienteMB
     */
    public ClienteMB() {
    }
    
    private Cliente cliente = new Cliente();
    private Usuario usuario = new Usuario();
    
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void novoCliente(){
        cliente = new Cliente();
    }
    
    public void editarCliente(Cliente cliente){
        
        try 
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("cliente", cliente);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroCliente.xhtml");
            
            setCliente(cliente);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void excluirCliente(Cliente cliente){
        Clientes.ClienteControlador.excluir(cliente);
        novoCliente();
        listarClientes();
    }
    
    public void salvarCliente(){
        //Recupera usuario da sessao
        FacesContext fc = FacesContext.getCurrentInstance();
        usuario.setCod_usuario((Integer) fc.getExternalContext().getSessionMap().get("usuario")); 
        
        usuario.getClientes().add(cliente);
        cliente.setUsuario(this.usuario);
        
        Clientes.ClienteControlador.salvar(cliente);
        novoCliente();
    }
    
    public void listarClientes(){
        FacesContext fc = FacesContext.getCurrentInstance();
        clientes = Clientes.ClienteControlador.getClientes((Integer) fc.getExternalContext().getSessionMap().get("usuario"));
    }
    
}
