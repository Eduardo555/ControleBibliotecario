/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Usuarios.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sun.invoke.empty.Empty;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped
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
    
    public String realizaLogout(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        
        return "/login.xhtml";
    }
    
    public String realizaLogin(){
        usuarios = Usuarios.UsuarioControlador.encontraUsuario(usuario.getEmail(), usuario.getSenha());
        if(usuarios.size() > 0){
            //Realiza Login          
            // Coloa o cod usuario na sessao
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().getSessionMap().put("usuario",usuarios.get(0).getCod_usuario());
            
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("home/home.xhtml");
                
            } catch (IOException ex) {
                Logger.getLogger(UsuarioMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //Usuario nao existe
        return "login.xhtml";
    }
    
}
