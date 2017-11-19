/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIvros;

import BibliotecarioServico.BibliotecarioServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author eduardo
 */
public class LivroControlador {
    
    public static void salvar(Livro livro) {
        EntityManager em = BibliotecarioServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(livro);
        t.commit();
    }
    
    public static void excluir(Livro livro) {
        EntityManager em = BibliotecarioServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Livro.class, livro.getCod_livro()));
        t.commit();
    }
    
    public static List<Livro> getLivros(Integer cod_usuario) {
        EntityManager em = BibliotecarioServico.getEM();
        TypedQuery<Livro> query = em.createQuery("select x from Livro x where x.usuario.cod_usuario =:cod_usuario", Livro.class);
        query.setParameter("cod_usuario", cod_usuario);
        return query.getResultList();
    }
}
