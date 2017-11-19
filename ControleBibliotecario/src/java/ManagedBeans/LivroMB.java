/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import LIvros.Livro;
import Usuarios.Usuario;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped
public class LivroMB {

    

    /**
     * Creates a new instance of LivroMB
     */
    
    
    Livro livro = new Livro();
    Usuario usuario = new Usuario();
    
    List<Livro> livros = new ArrayList<Livro>();
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public void novoLivro(){
        livro = new Livro();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    public LivroMB() {
        
    }
    
    public void exluirLivros(Livro livro){
        LIvros.LivroControlador.excluir(livro);
        listarLivros();
    }
    
    public void editarLivros(Livro livro){
        
        try 
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("livro", livro);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroLivro.xhtml");
            
            setLivro(livro);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(LivroMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void listarLivros(){
        
        //Recupera usuario da sessao
        FacesContext fc = FacesContext.getCurrentInstance();
        livros = LIvros.LivroControlador.getLivros((Integer) fc.getExternalContext().getSessionMap().get("usuario"));
    }
    
    public void salvarLivro(){
        
        //Recupera usuario da sessao
        FacesContext fc = FacesContext.getCurrentInstance();
        usuario.setCod_usuario((Integer) fc.getExternalContext().getSessionMap().get("usuario")); 
        
        usuario.getLivros().add(livro);
        livro.setUsuario(this.usuario);
        
        //usuario.addLivro(livro);
        LIvros.LivroControlador.salvar(livro);
        novoLivro();
    }
    
}
