/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import BibliotecarioServico.BibliotecarioServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author eduardo
 */
public class UsuarioControlador {
    
     public static void salvar(Usuario usuario) {
        EntityManager em = BibliotecarioServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(usuario);
        t.commit();
    }
    
     public static List<Usuario> encontraUsuario(String email, String senha){
         
        EntityManager em = BibliotecarioServico.getEM();
        TypedQuery<Usuario> query = em.createQuery("select x from Usuario x where x.email =:email and x.senha=:senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        
        return query.getResultList();
                 
     }
     
}
