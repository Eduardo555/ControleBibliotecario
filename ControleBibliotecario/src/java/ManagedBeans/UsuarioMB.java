/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sun.invoke.empty.Empty;

/**
 *
 * @author eduardo
 */
@ManagedBean
@ViewScoped
public class UsuarioMB {

    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
        
    }
    
    List<Usuario> usuarios = new ArrayList<Usuario>();
    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String voltarLogin(){
        return "login.xhtml";
    }
    
    public String salvarUsuario(){
        Usuarios.UsuarioControlador.salvar(this.usuario);
        return "/login.xhtml";
    }
    
    public String realizaLogin(){
        usuarios = Usuarios.UsuarioControlador.encontraUsuario(usuario.getEmail(), usuario.getSenha());
        if(usuarios.size() > 0){
            //Realiza Login
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarios);
            return "/home/home.xhtml";
        }
        //Usuario nao existe
        return "login.xhtml";
    }
    
}
